import random as rm
import math as mt

sigm = (lambda x: 1 / (1 + mt.e ** (-x)), lambda x: x * (1 - x))
cost = (lambda a, y: (a - y) ** 2, lambda a, y: (a - y))

class NeuralLayer:
    def __init__(self, inputs, neurons):
        self.inputs = inputs
        self.neurons = neurons
        self.w = []
        self.b = []
        self.z = []
        self.a = []
        for _ in range(0, neurons):
            aux = []
            for _ in range(0, inputs):
                aux.append(rm.random() * 2 - 1)
            self.w.append(aux)
        for _ in range(0, neurons):
            self.b.append(rm.random() * 2 - 1)
            self.z.append(rm.random() * 2 - 1)
            self.a.append(rm.random() * 2 - 1)

class NeuralNetwork:
    def __init__(self, layers):
        self.layer = []
        for i in range(0, len(layers) - 1):
            self.layer.append(NeuralLayer(layers[i], layers[i + 1]))

    def get_values(self, inputs):
        if len(inputs) != self.layer[0].inputs:
            print("Error: cantidad números de entradas no válidos")
            return None
        for l, layer in enumerate(self.layer): #layer
            a_1 = self.layer[l - 1].a if l != 0 else inputs
            for n in range(0, layer.neurons): #neuron
                z = 0
                for i in range(0, layer.inputs): #inputs
                    z += a_1[i] * layer.w[n][i]
                z += layer.b[n]
                layer.z[n] = z
                layer.a[n] = sigm[0](z)
                #print(l, ' ', layer.w[n], ' ', layer.b[n], ' ', layer.a[n]) #xd
        return self.layer[len(self.layer) - 1].a

    def train(self, inputs, outputs, lr):
        self.get_values(inputs)
        if len(self.layer[len(self.layer) - 1].a) != len(outputs):
            print("Error: cantidad números de salidas no válidos")
            return None
        deltas = []
        for l in reversed(range(0, len(self.layer))):
            delta = []
            layer = self.layer[l]
            if l == (len(self.layer) - 1):
                for a in range(0, len(outputs)):
                    delta.append(cost[1](outputs[a], layer.a[a]) * sigm[1](layer.a[a]))
            else:
                for a in range(0, len(layer.a)):
                    e = 0
                    for n in range(0, len(_w)):
                        e  += _w[n][a] * deltas[0][n]
                    delta.append(e * sigm[1](layer.a[a]))
            deltas.insert(0, delta)
            _w = []
            for item in layer.w:
                aux = []
                for input in item:
                    aux.append(input)
                _w.append(aux)
            #weights
            for n in range(0, layer.neurons):
                for i in range(0, layer.inputs):
                    if l == 0:
                        layer.w[n][i] = layer.w[n][i] + (deltas[0][n] * inputs[i] * lr)
                    else:
                        layer.w[n][i] = layer.w[n][i] + (deltas[0][n] * self.layer[l-1].a[i] * lr)
            #baias
            prom_deltas = 0
            for i in range(0, len(delta)):
                prom_deltas += delta[i]
            prom_deltas /= len(delta)
            for b in range(0, len(layer.b)):
                layer.b[b] = layer.b[b] + (prom_deltas * lr)
    
    def save_data(self, name_file):
        f = open(name_file, "w+")
        for layer in self.layer:
            f.write(str(layer.w))
            f.write('\n')
            f.write(str(layer.b))
            f.write('\n')
        f.close()

    def load_data(self, name_file):
        try:
            f = open(name_file, "r")
        except Exception:
            print("No se encotró el archivo")
            return
        try:
            txt = f.read()
            txt = txt.split("\n")
            txt = txt[0:(len(txt) - 1)]
            if(len(txt) != (len(self.layer) * 2)):
                print("Error al leer el archivo")
                return None
            weights = []
            for t, layer in enumerate(txt):
                if(t % 2 == 0):
                    layer = layer.split('], [')
                    weights = []
                    for neuron in layer:
                        neuron = neuron.replace('[', '')
                        neuron = neuron.replace(']', '')
                        neuron = neuron.split(',')
                        aux = []
                        for inputs in neuron:
                            aux.append(float(inputs))
                        weights.append(aux)
                else:
                    layer = layer.replace('[','')
                    layer = layer.replace(']','')
                    layer = layer.split(',')
                    bias = []
                    for b in layer:
                        bias.append(float(b))
                    self.layer[int((t - 1)/2)].w = weights
                    self.layer[int((t - 1)/2)].b = bias
        except Exception:
            print("Error al leer el archivo")
        finally:
            f.close()