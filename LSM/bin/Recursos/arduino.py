from neural_network import NeuralNetwork
import serial

tolerancia = 2000
null_value = [0,0,0,0,0,0]
#arduino = serial.Serial('COM4', baudrate=9600, timeout=1.0)
arduino = None
nn = NeuralNetwork([600, 100, 100, 3])
nn.load_data("data.txt")

def connect_arduino():
    port = 0
    conn = True
    while conn and port < 15:
        try:
            conn = False
            p = 'COM' + str(port)
            Arduino = serial.Serial(p, baudrate=9600, timeout=1.0)
        except Exception:
            conn = True
            port += 1
    return Arduino

def obt_val_arduino():
    linea = str(arduino.readline())
    linea = linea.replace("\\r\\n",'')
    linea = linea.replace("b",'')
    linea = linea.replace('\'','')
    linea = linea.split(',')
    valores = []
    if(len(linea) == 6):
        for valor in linea:
            try:
                valores.append(int(valor))
            except Exception:
                return null_value
        return valores
    else:
        return null_value

def get_output():
    val = obt_val_arduino()
    #while(type(val) != list):
    #    val = obt_val_arduino()
    while ((val[3] < -tolerancia or val[3] > tolerancia) and (val[4] < -tolerancia or val[4] > tolerancia) and (val[5] < -tolerancia or val[5] > tolerancia)) != True:
        val = obt_val_arduino()
    valores = []
    for _ in range(0, 100):
        val = obt_val_arduino()
        for elemento in val:
            valores.append(elemento / 32768)
        print(val)
    val = nn.get_values(valores)
    for i in range(len(val)):
        if(val[i] > 0.5):
            val[i] = 1
        else:
            val[i] = 0
    return val

arduino = connect_arduino()