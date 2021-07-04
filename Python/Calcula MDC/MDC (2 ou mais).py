# Programa que calcula MDC de dois ou mais fatores

valores = []
valor = 0
nome = str(input("Qual o seu nome:  "))
while (valor != 1):
    valor = int(input("Insira um valor: (Digite 1 para concluir) "))
    if (valor != 1):
        valores.append(valor)

menor = valores[0]
z = 0
while( z < len(valores)):
    if (menor > valores[z]):
        menor = valores[z]
    z = z + 1

NMDC = []
i = 2 #Primeiro fator Primo
while (i <= menor):
    j = 0
    MDC = 0
    while (j < len(valores)):
        if( valores[j] % i != 0):
            MDC = MDC + 1
        
        if (j == len(valores) - 1 and MDC == 0):
            NMDC.append(i)
            n = 0
            while (n < len(valores)):
                valores[n] = valores[n] // i
                n = n + 1   
            k = 0
            while( k < len(valores)):
                if (menor > valores[k]):
                    menor = valores[k]
                k = k + 1
            i = 1
        j = j + 1
    i = i + 1
multi = 1
n = 0

while ( n < len(NMDC)):
    multi = multi * NMDC[n]
    n = n + 1

print("Olá " + nome + "\nO MDC dos valores eh : " + str(multi))

#Programa feito por Luis Filipe
                
                
                
                
        
