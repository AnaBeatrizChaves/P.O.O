#include <stdio.h>
#include "Funcoes.c"
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int main() {
    int opcao;
    int id;
    Lista l;
    inicializarLista(&l);

    do {
        printf("\n=============================================\n");
        printf("============= LISTA DE COMPRAS ==============\n");
        printf("\nO que deseja fazer?\n");
        printf("1. Inserir novo item\n");
        printf("2. Mostrar itens cadastrados\n");
        printf("3. Buscar por item\n");
        printf("4. Editar informacoes de um item\n");
        printf("5. Remover item\n");
        printf("6. Marcar item como Comprado\n");
        printf("7. Sair\n");
        printf("\n=============================================\n");
        printf("Digite o valor correspondente: ");

        char input[10];
        int i;

        scanf("%s", input);

        for (i = 0; input[i] != '\0'; i++) {
            if (!isdigit(input[i])) {
                printf("Entrada invalida. Digite uma opcao valida.\n");
                break;
            }
        }

        if (i == strlen(input)) {
            opcao = atoi(input);

            if (opcao < 1 || opcao > 7) {
                printf("\nOpcao invalida. Digite uma opcao valida.\n");
            } else {
                switch (opcao) {
                    case 1:
                        inserir_novo_item(&l);
                        break;
                    case 2:
                        mostrar_itens_cadastrados(&l);
                        break;
                    case 3:
                        buscar_por_item(&l);
                        break;
                    case 4:
                        editar_informacoes_de_um_item(&l);
                        break;
                    case 5:
                        removerItem(&l, id);
                        break;
                    case 6:
                        marcar_item_como_comprado(&l);
                        break;
                    case 7:
                        encerrar_programa(&l);
                        break;
                }
            }
        }
    } while (opcao != 7);
}