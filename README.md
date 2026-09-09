# Atividade Avaliativa - Estruturas de Dados

Arrays, Matrizes, Algoritmos de Ordenacao e Busca

## Descricao

Este repositorio contem a implementacao em Java dos experimentos pedidos na atividade avaliativa de Estruturas de Dados:

- Comparacao entre Bubble Sort e Quick Sort, contando comparacoes e trocas/movimentacoes para arrays de 10, 20 e 1000 elementos
- Busca sequencial em matrizes 2x2, 10x10 e 100x100, contando comparacoes
- Hands On 1: investigacao de um array de temperaturas
- Hands On 2: monitoramento de sensores com matriz 5x24

O relatorio completo, com a pesquisa teorica, as tabelas comparativas, os resultados experimentais e a analise/conclusao, esta em `docs/relatorio_estruturas_de_dados_java.docx`.

## Estrutura do repositorio

```
.
├── README.md
├── docs/
│   └── relatorio_estruturas_de_dados_java.docx
└── src/
    ├── Parte2Ordenacao.java
    ├── Parte3BuscaMatriz.java
    ├── Parte4HandsOn1.java
    └── Parte5HandsOn2.java
```

## Como compilar e executar

Requer Java Development Kit (JDK) instalado.

```bash
cd src
javac Parte2Ordenacao.java
javac Parte3BuscaMatriz.java
javac Parte4HandsOn1.java
javac Parte5HandsOn2.java

java Parte2Ordenacao
java Parte3BuscaMatriz
java Parte4HandsOn1
java Parte5HandsOn2
```

## Resumo dos programas

| Arquivo | Descricao |
|---|---|
| `Parte2Ordenacao.java` | Gera arrays de 10, 20 e 1000 elementos e compara Bubble Sort e Quick Sort contando comparacoes e trocas/movimentacoes |
| `Parte3BuscaMatriz.java` | Busca sequencial com loops aninhados em matrizes 2x2, 10x10 e 100x100, contando comparacoes |
| `Parte4HandsOn1.java` | Array de 10 temperaturas: media, maior, menor, indices e contagem acima da media |
| `Parte5HandsOn2.java` | Matriz 5x24 de sensores: medias por sensor, maior temperatura, media geral e leituras acima de um limite |

## Autor

Trabalho academico da disciplina de Estruturas de Dados.
