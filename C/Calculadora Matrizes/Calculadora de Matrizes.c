
#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <assert.h>

int main(void)
{
	setlocale (LC_ALL, "portuguese");
	
	int La = 0,Ca = 0,Lb = 0,Cb = 0;
	
	char condicao = 'f';
	
	while(condicao == 'f'){
	printf("insira o tamanho de linhas da primeira matriz: ");
	scanf("%i", &La);
	printf("Insira o tamanho de colunas da primeira matriz: ");
	scanf("%i", &Ca);
	if (La >= 11 || Ca >= 11){
		printf("Por favor, insira valores entre 1 e 10! \n");
		}
		else{
			condicao = 'v';
		}
	}
	
	int Ma[La][Ca],i=0, j=0;
	
	while (i < La){
		while (j < Ca){
			printf("Insira o valor para o elemento [%i][%i]:", i+1,j+1);
			scanf("%d", &Ma[i][j]);
			j = j + 1;
		}
		j=0;
		i = i + 1;
	}
	i = 0;
	j = 0;
	while (i < La){
		printf("|");
		while (j < Ca){
			printf("[%i]", Ma[i][j]);
			j++;
		}
		printf("|\n");
		j = 0;
		i = i + 1;
	}
	
	i = 0;
	j = 0;
	
	condicao = 'f';
	while(condicao == 'f'){
	printf("insira o tamanho de linhas da segunda matriz: ");
	scanf("%i", &Lb);
	printf("Insira o tamanho de colunas da segunda matriz: ");
	scanf("%i", &Cb);
	if (Lb >= 11 || Cb >= 11){
		printf("Por favor, insira valores entre 1 e 10! \n");
		}
		else{
			condicao = 'v';
		}
	}
	
	int Mb[Lb][Cb];
	while (i < Lb){
		while (j < Cb){
			printf("Insira o valor para o elemento [%i][%i]:", i+1,j+1);
			scanf("%d", &Mb[i][j]);
			j = j + 1;
			}
		j=0;
		i = i + 1;
	}
	i = 0;
	j = 0;
	while (i < Lb){
		printf("|");
		while (j < Cb){
			printf("[%i]", Mb[i][j]);
			j++;
		}
		printf("|\n");
		j=0;
		i++;
	}
	/* Primeira Parte */

	if ((La == Lb && Ca == Cb) && ( Ca == Lb)){
		if (La == Ca) {
			/* adicao */
			int Mc[La][Ca];
			i = 0;
			j = 0;
			while (i < La){
				while (j < Ca){
					Mc[i][j] = Ma[i][j] + Mb[i][j];
					j = j + 1;
				}
				j = 0;
				i = i + 1;
			}
			
			i = 0;
			j = 0;
			printf("\n \n \n A soma das matrizes Quadradas A e B eh: \n");
			while (i < La){
				printf("|");
				while (j < Ca){
					printf("[%i]", Mc[i][j]);
					j = j + 1;
				}
				printf("| \n");
				j = 0;
				i = i + 1;
				}
			/* Subtracao */
			int Md[La][Ca];
			i = 0;
			j = 0;
			while (i < La){
				while (j < Ca){
					Md[i][j] = Ma[i][j] - Mb[i][j];
					j = j + 1;
				}
				j = 0;
				i = i + 1;		
			}
			
			i = 0;
			j = 0;
			printf("\n \n \n A Subtracao das matrizes Quadradas A e B eh: \n");
			while (i < La){
				printf("|");
				while (j < Ca){
					printf("[%i]", Md[i][j]);
					j = j + 1;
				}
				printf("| \n");
				j = 0;
				i = i + 1;
				}
			
			/* Multiplicacao */
			int Me[La][Cb], k, mult;
			i = 0;
			j = 0;
			k = 0;
			
			while(i < La){
				while(j < Cb){
					mult = 0;
					k = 0;
					while(k < Cb){
					mult = mult + Ma[i][k]*Mb[k][j];
					k = k + 1;
				}	
					Me[i][j] = mult;
					j = j + 1;
				}
				j = 0;
				i = i + 1;
			}
			
			i = 0;
			j = 0;
			printf("\n \n \n A multiplicacao das matrizes Quadradas A e B eh: \n");
			while (i < La){
				printf("|");
				while (j < Cb){
					printf("[%i]", Me[i][j]);
					j = j + 1;
				}
				printf("| \n");
				j = 0;
				i = i + 1;
				}
				
			/* Diagonal primária e secundária */
			
			/* Matriz a */
			i = 0;
			j = 0;
			printf("\n\n Diagonal principal MATRIZ A \n");
			while(i < La){
				while (j < Ca){
					if ( i == j){
						printf("[%d]", Ma[i][j]);
					}
					j = j + 1;
				}
				j = 0;
				i = i + 1;
			}
			printf("\n \nDiagonal secundaria MATRIZ A \n"),
			i = 0;
			j = 0;
			while(i < La){
				while (j < Ca){
					if ( (i + 1 + j + 1 - La) == 1){
						printf("[%d]", Ma[i][j]);
					}
					j = j + 1;
				}
				j = 0;
				i = i + 1;
			}
			
			/* Matriz b */
			i = 0;
			j = 0;
			printf("\n \nDiagonal principal MATRIZ B\n");
			while(i < La){
				while (j < Ca){
					if ( i == j){
						printf("[%d]", Mb[i][j]);
					}
					j = j + 1;
				}
				j = 0;
				i = i + 1;
			}
			printf("\n \n Diagonal secundaria MATRIZ B \n"),
			i = 0;
			j = 0;
			while(i < La){
				while (j < Ca){
					if ( (i + 1 + j + 1 - La) == 1){
						printf("[%d]", Mb[i][j]);
					}
					j = j + 1;
				}
				j = 0;
				i = i + 1;
			}
			
			/* Matriz c */
			i = 0;
			j = 0;
			printf("\n \nDiagonal principal MATRIZ C\n");
			while(i < La){
				while (j < Ca){
					if ( i == j){
						printf("[%d]", Mc[i][j]);
					}
					j = j + 1;
				}
				j = 0;
				i = i + 1;
			}
			printf("\n \n Diagonal secundaria MATRIZ C \n"),
			i = 0;
			j = 0;
			while(i < La){
				while (j < Ca){
					if ( (i + 1 + j + 1 - La) == 1){
						printf("[%d]", Mc[i][j]);
					}
					j = j + 1;
				}
				j = 0;
				i = i + 1;
			}
			
			/* Matriz d */
			i = 0;
			j = 0;
			printf("\n \nDiagonal principal MATRIZ D\n");
			while(i < La){
				while (j < Ca){
					if ( i == j){
						printf("[%d]", Md[i][j]);
					}
					j = j + 1;
				}
				j = 0;
				i = i + 1;
			}
			printf("\n \n Diagonal secundaria MATRIZ D \n"),
			i = 0;
			j = 0;
			while(i < La){
				while (j < Ca){
					if ( (i + 1 + j + 1 - La) == 1){
						printf("[%d]", Md[i][j]);
					}
					j = j + 1;
				}
				j = 0;
				i = i + 1;
			}
			
			/* Matriz e */
			i = 0;
			j = 0;
			printf("\n \nDiagonal principal MATRIZ E\n");
			while(i < La){
				while (j < Ca){
					if ( i == j){
						printf("[%d]", Me[i][j]);
					}
					j = j + 1;
				}
				j = 0;
				i = i + 1;
			}
			printf("\n \n Diagonal secundaria MATRIZ E \n"),
			i = 0;
			j = 0;
			while(i < La){
				while (j < Ca){
					if ( (i + 1 + j + 1 - La) == 1){
						printf("[%d]", Me[i][j]);
					}
					j = j + 1;
				}
				j = 0;
				i = i + 1;
				}
			}
		printf("\n\n\n Programa feito por Luis Filipe !!! \n");	
		}
		
		/* segunda parte */ 
		
		if (((Ca == Lb) || (Cb == La)) && ((La != Ca) || (Lb != Cb))){
			/* multiplicacao A*B */
			if (Ca == Lb){
			int l, mult1, Me1[La][Cb];
			i = 0;
			j = 0;
			l = 0;
			mult1 = 0;
			while (i < La){
				while(j < Cb){
					mult1 = 0;
					l = 0;
					while (l < Ca){
						mult1 = mult1 + Ma[i][l]*Mb[l][j];
						l = l + 1;
					}
					Me1[i][j] = mult1;
					j = j + 1;
				}
				j = 0;
				i = i + 1;
			}
			
			i = 0;
			j = 0;
			printf("\n\n A resultante da matriz Multiplicacao MA*MB eh: \n");
			while (i < La){
				printf("|");
				while (j < Cb){
					printf("[%d]", Me1[i][j]);
					j = j + 1;
				}
				printf("| \n");
				j = 0;
				i = i + 1;
			}
			/* Matriz Transposta E1 */
			i = 0;
			j = 0;
			printf("\n A Matriz transposta de ME1 eh: \n");
			while(i < Cb){
				printf("|");
				while(j < La){
					printf("[%d]", Me1[j][i]);
					j = j + 1;
				}
				printf("| \n");
				j = 0;
				i = i + 1;
				}
			}
		
		/* multiplicacao B*A */
		
		if (Cb == La){
			int m, mult2, Me2[Lb][Ca];
			i = 0;
			j = 0;
			m = 0;
			mult2 = 0;
			while (i < Lb){
				while(j < Ca){
					mult2 = 0;
					m = 0;
					while (m < Cb){
						mult2 = mult2 + Mb[i][m]*Ma[m][j];
						m = m + 1;
					}
					Me2[i][j] = mult2;
					j = j + 1;
				}
				j = 0;
				i = i + 1;
			}
			
			i = 0;
			j = 0;
			printf("\n\n A resultante da matriz Multiplicacao MB*MA eh: \n");
			while (i < Lb){
				printf("|");
				while (j < Ca){
					printf("[%d]", Me2[i][j]);
					j = j + 1;
				}
				printf("| \n");
				j = 0;
				i = i + 1;
			}
			/* Matriz Transposta E2 */
			i = 0;
			j = 0;
			printf("\n A Matriz transposta de ME2 eh: \n");
			while(i < Ca){
				printf("|");
				while(j < Lb){
					printf("[%d]", Me2[j][i]);
					j = j + 1;
				}
				printf("| \n");
				j = 0;
				i = i + 1;
				}
			}
			
			/* MATRIZ TRANSPOSTA */
			/* Matriz Transposta A */
			i = 0;
			j = 0;
			printf("\n A Matriz transposta de MA eh: \n");
			while(i < Ca){
				printf("|");
				while(j < La){
					printf("[%d]", Ma[j][i]);
					j = j + 1;
				}
				printf("| \n");
				j = 0;
				i = i + 1;
			}
			
			/* Matriz Transposta B */
			i = 0;
			j = 0;
			printf("\n A Matriz transposta de MB eh: \n");
			while(i < Cb){
				printf("|");
				while(j < Lb){
					printf("[%d]", Mb[j][i]);
					j = j + 1;
				}
				printf("| \n");
				j = 0;
				i = i + 1;
			}
		printf("\n \n \n  Programa feito por Luis Filipe !!! \n");	
		}
		
		/* Terceira Parte */
		if (((La == Lb) && (Ca == Cb)) && ((La != Ca) && (Lb != Cb)) && ((Ca != Lb) && (Cb != La))){
			/* adicao */
			int Mc1[La][Ca];
			i = 0;
			j = 0;
			while (i < La){
				while (j < Ca){
					Mc1[i][j] = Ma[i][j] + Mb[i][j];
					j = j + 1;
				}
				j = 0;
				i = i + 1;
			}
			i = 0;
			j = 0;
			printf("\n \n \n A soma das matrizes eh: \n");
			while (i < La){
				printf("|");
				while (j < Ca){
					printf("[%i]", Mc1[i][j]);
					j = j + 1;
				}
				printf("| \n");
				j = 0;
				i = i + 1;
				}
				
			/* Matriz Transposta A */
			i = 0;
			j = 0;
			printf("\n A Matriz transposta de MA eh: \n");
			while(i < Ca){
				printf("|");
				while(j < La){
					printf("[%d]", Ma[j][i]);
					j = j + 1;
				}
				printf("| \n");
				j = 0;
				i = i + 1;
			}
			
			/* Matriz Transposta B */
			i = 0;
			j = 0;
			printf("\n A Matriz transposta de MB eh: \n");
			while(i < Cb){
				printf("|");
				while(j < Lb){
					printf("[%d]", Mb[j][i]);
					j = j + 1;
				}
				printf("| \n");
				j = 0;
				i = i + 1;
			}
			
			/* Matriz Transposta Mc1 */
			i = 0;
			j = 0;
			printf("\n A Matriz transposta de MC1 eh: \n");
			while(i < Ca){
				printf("|");
				while(j < La){
					printf("[%d]", Mc1[j][i]);
					j = j + 1;
				}
				printf("| \n");
				j = 0;
				i = i + 1;
			}
			printf("\n \n \n Programa feito por Luis Filipe !!! \n");
			}
	system("PAUSE");
	return 0;
}

