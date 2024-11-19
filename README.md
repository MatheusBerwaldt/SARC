# SARC - Simulador de Análise de Redes e Custos

Este projeto consiste em um simulador para análise de sistemas de filas, redes e custos. Ele foi desenvolvido com o objetivo de estudar gargalos, propor melhorias e realizar análises estatísticas para suportar decisões em sistemas complexos.

## Funcionalidades

- Simulação de sistemas de filas com parâmetros customizáveis.
- Análise de desempenho, incluindo:
  - **Probabilidades dos estados das filas**.
  - **Índices de desempenho**, como tempo de espera e ocupação dos servidores.
  - **Comparação entre modelos original e otimizado**.
- Configuração de múltiplas filas e roteamento entre elas via arquivo YAML.
- Relatórios detalhados sobre os resultados da simulação.

## Estrutura do Projeto

```plaintext
SARC/
├── src/              # Código-fonte principal
├── config/           # Arquivos de configuração (ex.: YAML)
├── docs/             # Documentação e relatórios
├── tests/            # Testes automatizados
└── README.md         # Documentação do projeto
