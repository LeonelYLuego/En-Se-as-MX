import serial
arduino = serial.Serial('COM4', baudrate=9600, timeout=1.0)

def obt_val_arduino():
    linea = str(arduino.readline())
    linea = linea.replace("\\r\\n",'')
    linea = linea.replace("b",'')
    linea = linea.replace('\'','')
    linea = linea.split(',')
    valores = []
    if(len(linea) == 6):
        for valor in linea:
            valores.append(int(valor))
        return valores
    else:
        return None