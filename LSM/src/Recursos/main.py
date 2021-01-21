import socket
#import arduino

data = {'Aa':[0,0,1], 'Bb':[0,1,0], 'Cc':[1,0,0]}

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind(('localhost', 5000))
s.listen(5)

while True:
    clientsocket, address = s.accept()
    print(f"Connection from {address} has been established")
    msg = clientsocket.recv(1024)
    msg = msg.decode("utf-8")
    msg = list(msg)
    msg = msg[2::]
    msg = ''.join(msg)
    print(msg)
    if(msg == 'exit'):
        exit()
    '''a = arduino.get_output()
    print(a)
    clientsocket.send(bytes('1' if data[msg] == a else '0', 'utf-8'))'''
    clientsocket.send(bytes('0', 'utf-8'))
    print('Mensaje enviado')