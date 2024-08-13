#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Item{
    int id;
    char Nome[50];
    char Status[20];
} Item;

typedef struct listaDeItens {
    Item *Itens;
    int posicaoAtual;
    int capacidade;
} Lista;

void inicializarLista(Lista *l) {
    l->capacidade = 10;
    l->Itens = (Item*)calloc(l->capacidade, sizeof(Item));
    l->posicaoAtual = 0;
}

void redimensionarLista(Lista *l) {
    if (l->posicaoAtual == l->capacidade) {
        l->capacidade *= 2; 
        l->Itens = (Item*)realloc(l->Itens, l->capacidade * sizeof(Item));
    }
}

void inserir_novo_item(Lista *l) {
    redimensionarLista(l); 

    printf("\nDigite o nome do item em ate 50 caracteres:");
    scanf(" %49[^\n]", l->Itens[l->posicaoAtual].Nome);
    printf("Digite o status do item, sendo:\n");
    printf("1 - Pendente\n");
    printf("2 - Comprado\n");
    int status;
    scanf("%d", &status);
    while (status < 1 || status > 2) {
        printf("Status invalido! Digite novamente:\n");
        scanf("%d", &status);
    }
    strcpy(l->Itens[l->posicaoAtual].Status, status == 1 ? "Pendente" : "Comprado");

    l->Itens[l->posicaoAtual].id = l->posicaoAtual + 1;
    l->posicaoAtual++;

    printf("\nItem inserido com sucesso!\n");
}

void mostrar_itens_cadastrados(Lista *l) {
    if (l->posicaoAtual == 0) {
        printf("\nNenhum item cadastrado.\n");
        return;
    }

    printf("\nItens cadastrados:\n");
    for (int i = 0; i < l->posicaoAtual; i++) {
        printf("\nItem %d:\n", l->Itens[i].id);
        printf("Nome: %s\n", l->Itens[i].Nome);
        printf("Status: %s\n", l->Itens[i].Status);
    }
}

void buscar_por_item(Lista *l) {
    char termo[50];
    printf("Digite o nome do item a ser buscado: ");
    scanf(" %49[^\n]", termo);

    int encontrado = 0;
    for (int i = 0; i < l->posicaoAtual; i++) {
        if (strstr(l->Itens[i].Nome, termo) != NULL) {
            printf("\nItem %d:\n", l->Itens[i].id);
            printf("Nome: %s\n", l->Itens[i].Nome);
            printf("Status: %s\n", l->Itens[i].Status);
            encontrado = 1;
        }
    }

    if (!encontrado) {
        printf("Nenhum item encontrado com o termo '%s'.\n", termo);
    }
}


void editar_informacoes_de_um_item(Lista *l) {
    int numero, opcao;
    printf("\nDigite o numero do item que voce quer editar:\n");
    for (int i = 0; i < l->posicaoAtual; i++) {
        printf("Item %d: %s\n", l->Itens[i].id, l->Itens[i].Nome);
    }
    scanf("%d", &numero);

    Item *Item = NULL;
    for (int i = 0; i < l->posicaoAtual; i++) {
        if (l->Itens[i].id == numero) {
            Item = &l->Itens[i];
            break;
        }
    }

    if (Item == NULL) {
        printf("\nItem nao encontrado.\n");
        return;
    }

    printf("\nO que voce quer editar no item %d?\n", numero);
    printf("1. Nome\n");
    printf("2. Status\n");
    printf("3. Voltar\n");
    scanf("%d", &opcao);

    switch (opcao) {
        case 1:
            printf("\nDigite o novo nome do item em ate 50 caracteres:\n");
            scanf(" %49[^\n]", Item->Nome);
            printf("\nNome alterado com sucesso!\n");
            break;
        case 2:
         
            printf("\nDigite o novo status do item, sendo:\n");
            printf("1 - Pendente\n");
            printf("2 - Comprado\n");
            int novo_status;
            scanf("%d", &novo_status);
            strcpy(Item->Status, novo_status == 1 ? "Pendente" : "Comprado");
            printf("\nStatus alterado com sucesso!\n");
            break;

        case 3:
            return;
    }
}

void removerItem(Lista *l, int id) {
    int encontrado = 0;

    printf("\nID's dos itens:\n");
        for (int i = 0; i < l->posicaoAtual; i++) {
            printf("Id %d:\nNome: %s\n\n", l->Itens[i].id, l->Itens[i].Nome);
        }

    printf("Digite o ID do item a ser removido:\n ");
    scanf("%d", &id);

        for (int i = 0; i < l->posicaoAtual; i++) {
            if (l->Itens[i].id == id) {
                encontrado = 1;
                for (int j = i; j < l->posicaoAtual - 1; j++) {
                    l->Itens[j] = l->Itens[j + 1];
                }
                l->posicaoAtual--;
                printf("Item removido com sucesso.\n");
                break;
            }
    }
    if (!encontrado) {
        printf("Item com ID %d nao encontrado.\n", id);
    }
}

void marcar_item_como_comprado(Lista *l) {
    mostrar_itens_cadastrados(l);
    if (l->posicaoAtual == 0) {
        printf("Nenhum item cadastrado.\n");
        return;
    }

    int indice;
    printf("Digite o numero do item Comprado:\n ");
    scanf("%d", &indice);

    if (indice >= 1 && indice <= l->posicaoAtual) {
        strcpy(l->Itens[indice - 1].Status, "Comprado");
        printf("Item marcado como Comprado.\n");
    } else {
        printf("Indice invalido.\n");
    }
}

void encerrar_programa(Lista *l) {
    if (l->Itens != NULL) {
        free(l->Itens);
        l->Itens = NULL;
    }
    printf("Programa encerrado com sucesso. Ate mais!\n");
    exit(0);
}
