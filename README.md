# SARC - SIMULADOR DE ANÁLISE DE REDES E CUSTOS

Este projeto consiste em um simulador para análise de sistemas de filas, redes e custos. Ele foi desenvolvido com o objetivo de estudar gargalos, propor melhorias e realizar análises estatísticas para suportar decisões em sistemas complexos.

## FUNCIONALIDADES

- Simulação de sistemas de filas com parâmetros customizáveis.
- Análise de desempenho, incluindo:
  - **Probabilidades dos estados das filas**.
  - **Índices de desempenho**, tempo de espera e ocupação dos servidores.
  - **Comparação entre modelos original e otimizado**.
- Configuração de múltiplas filas e roteamento entre elas via arquivo YAML.
- Relatórios detalhados sobre os resultados da simulação.

## ESTRUTURA DE PROJETO

```plaintext
SARC/
├── src/              # Código-fonte principal
├── config/           # Arquivos de configuração (ex.: YAML)
├── docs/             # Documentação e relatórios
├── tests/            # Testes automatizados
└── README.md         # Documentação do projeto
