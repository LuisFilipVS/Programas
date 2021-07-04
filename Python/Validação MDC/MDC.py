#Programa que valida Axioma matemático - (O MDC de dois numeros consecutivos é 1)
print("Esse Programa que valida Axioma matemático - (O MDC de dois numeros consecutivos é 1)")
def calculaFatores(n1):
    i = 2
    fatores = []
    while (i <= n1):
        if ( n1 % i == 0):
            fatores.append(i)
            n1 = n1 // i
            i = 2
        else:
            i = i + 1        
    return fatores


validacao = False
n1 = 2
n2 = n1 + 1
while(n2 <= 1000):
    Fn1 = calculaFatores(n1)
    Fn2 = calculaFatores(n2)
    mdc = []
    i = 0
    while(i < len(Fn1)):
        j = 0
        while (j < len(Fn2) and validacao == False):
            if (Fn1[i] == Fn2[j]):
                mdc.append(Fn1[i])
                del(Fn1[i])
                del(Fn2[j])
                i = -1
                j = len(Fn2)
                print("Para o valores: " + str(n1) + " e " + str(n2) + " ,o MDC eh " + str(mdc))
                validacao = True
            else:
                j = j + 1
        i = i + 1
    if (validacao == False):
        print("Para o valores: " + str(n1) + " e " + str(n2) + " ,o MDC eh " + str(mdc))
    n1 = n1 + 1
    n2 = n1 + 1
    
        
                


        
