# **Tradutor & Interpretador**

Um interpretador de expressões aritméticas e comandos desenvolvido em Java. Este projeto implementa os estágios fundamentais de um compilador/interpretador (Análise Léxica, Sintática e Semântica) para processar e executar operações matemáticas básicas.  
Desenvolvido como parte da disciplina de **Compiladores** do curso de **Engenharia da Computação** na **Universidade Federal do Maranhão (UFMA)**.

## **Sobre o Projeto**

O objetivo deste projeto foi colocar em prática os conceitos teóricos de design de compiladores, construindo manualmente os componentes essenciais sem o uso de geradores automáticos (como Yacc ou ANTLR).  
O sistema é capaz de ler uma entrada de código fonte (expressões), convertê-la em tokens, analisar sua estrutura gramatical e, por fim, interpretar e executar os comandos, exibindo o resultado.

### **Funcionalidades Implementadas**

* **Análise Léxica (Scanner):** Reconhecimento de tokens, incluindo números inteiros e operadores.  
* **Análise Sintática (Parser):** Validação da gramática das expressões.  
* **Interpretação:** Execução direta da árvore sintática ou comandos.  
* **Operações Suportadas:**  
  * Suporte a tokens numéricos.  
  * Operações de Multiplicação (\*).  
  * Operações de Divisão (/).

## **Estrutura do Código**

O projeto segue a arquitetura clássica de interpretadores:

* Main.java: Ponto de entrada da aplicação. Inicializa o pipeline de interpretação.  
* Scanner.java: Responsável por ler a string de entrada caractere por caractere e agrupar em **Tokens**.  
* Token.java / TokenType.java: Define a estrutura e os tipos de tokens aceitos pela linguagem (ex: NUMBER, STAR, SLASH).  
* Parser.java: Recebe a lista de tokens do Scanner e verifica se eles obedecem às regras gramaticais da linguagem, gerando comandos.  
* Interpreter.java: Executa a lógica associada aos comandos processados pelo Parser.  
* Command.java: Interface ou classe abstrata para representar as instruções executáveis.

## **Tecnologias Utilizadas**

* **Linguagem:** Java (JDK 17 ou superior recomendado)  
* **Ferramentas:** Git

## **Como Executar**

Para rodar o projeto localmente, siga os passos abaixo:

1. **Clone o repositório:**  
   ```Bash  
   git clone https://github.com/KevenGustavo/Tradutor-Interpretador.git  
   cd Tradutor-Interpretador
   ```

2. **Compile os arquivos Java:**  
   ```Bash  
   javac *.java
   ```

3. **Execute a aplicação:**  
   ```Bash  
   java Main
   ```

## **Aprendizados**

Este projeto permitiu o aprofundamento em:

* Manipulação de strings e autômatos finitos para tokenização.  
* Gramáticas Livres de Contexto (GLC) e análise descendente (Recursive Descent Parsing).  
* Padrões de projeto como **Interpreter Pattern**.

***

### **Autor: [Keven Gomes](https://www.linkedin.com/in/keven-gomes/)**
