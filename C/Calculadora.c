#include <stdio.h>
#include <stdlib.h>
#include <math.h>

double somar(double a,double b);
double subtracao(double a,double b);
double  divisao(double a,double b);
double multiplicacao(double a,double b);
void calcular(int operador,double a,double b);
int main() {
    double a, b;
    int operacao;
    char continuar = 's'; 

    while(continuar=='s'||continuar=='S'){
        printf("\nEscolha a operação que será realizada:\n");
        printf("1 - Soma\n2 - Subtração\n3 - Divisão\n4 - Multiplicação\n");
        printf("0 - Sair\n");
        printf("Digite o número da operação: ");
        scanf("%d",&operacao);

        if(operacao==0){
            printf("Encerrando a calculadora.\n");
            break;
        }
        if (operacao < 1 || operacao > 4) {
            printf("Operação inválida! Tente novamente.\n");
            continue;
        }
        printf("Digite os dois números para a operação: ");
        scanf("%lf %lf",&a,&b);
        calcular(operacao,a,b);
        printf("\nQuer realizar outra operação? (s/n): ");
        scanf(" %c",&continuar);
    }

return 0;
}


double somar(double a,double b){
    return a+b;
}

double subtracao(double a,double b){
    return a-b;
}

double divisao(double a,double b){
    return a/b;
}
double multiplicacao(double a ,double b){
    return a*b;
}

void calcular(int operador,double a,double b){
    switch(operador){
    case 1:
        printf("\nO resultado da soma foi: %.2lf",somar(a,b));
        break;
    case 2: 
        printf("\nO resultado da subtração foi: %.2lf",subtracao(a,b));
        break;
    case 3:
        if(b==0) {
        printf("Erro,divisão com 0!");
        }else{
        printf("\nO resultado da divisão foi: %.2lf",divisao(a,b));
        }
        break;
    case 4:
        printf("\nO resultado da multiplicação foi: %.2lf",multiplicacao(a,b));
        break;
    default:
        printf("Tente novamente com uma operação válida");
        break;
    }
}

