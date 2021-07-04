#include <stdio.h>
#include <stdlib.h>

int main (void){
    int valor, i=0, bin[8];
    char condicao = 'f';
    printf("Programa Converte Decimal. para Binario. (8 bits) \n");
    while(condicao == 'f'){
        printf("Insira o valor em decimal \n");
        scanf("%d", &valor);
        if (valor > 255){
            printf("Insira um valor entre 0 e 255!!! \n \n");
        }
        else{
            condicao = 'v';
        }
    }
    while (valor > 2){
        bin[i] = valor % 2;
        valor = valor / 2;
        i++;
    }
    if (valor <= 2 && valor > 0){
        bin[i] = valor % 2;
        i++;
        bin[i] = valor / 2;
        valor = valor / 2;
        i++;
    }
    if (i <= 7){
        while (i <= 7){
            bin[i] = 0;
            i++;
        }
    }
    i = 7;
    printf("\n\n [");
    while (i >= 0){
        printf(" %d ", bin[i]);
        i--;
    }

    printf("] \n\nPrograma feito por Luis Filipe!!! \n");
    system("PAUSE");
    return 0;
}