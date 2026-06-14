# 🏥 Sistema de Gerenciamento de Atendimentos de Saúde

> Projeto Final — Unidade III | Programação de Computadores · UFERSA 2026.1  
> Prof.ª Welliana Benevides Ramalho

---

## 📋 Sobre o Projeto

Sistema desenvolvido em **Java** que modela o fluxo completo de atendimento de uma unidade de saúde — do cadastro do paciente na recepção, passando pela triagem de risco realizada pelo enfermeiro, até a consulta médica com registro de diagnóstico e prescrição.

O projeto aplica integralmente os conceitos de **Programação Orientada a Objetos (POO)**:

- ✅ Classes e Objetos  
- ✅ Encapsulamento  
- ✅ Herança (dois níveis)  
- ✅ Classes Abstratas  
- ✅ Interfaces  
- ✅ Polimorfismo  

---

## 🗂️ Estrutura do Projeto

```
src/
├── Atendivel.java          # Interface — profissionais que realizam atendimentos
├── Registravel.java        # Interface — eventos clínicos registráveis
├── Pessoa.java             # Classe abstrata raiz
├── Funcionario.java        # Classe abstrata (herda de Pessoa)
├── Paciente.java           # Herda de Pessoa; mantém histórico clínico
├── Medico.java             # Herda de Funcionario; implementa Atendivel
├── Enfermeiro.java         # Herda de Funcionario; implementa Atendivel
├── Recepcionista.java      # Herda de Funcionario
├── Consulta.java           # Implementa Registravel; numeração automática
├── Triagem.java            # Implementa Registravel; Escala de Manchester
├── SistemaAtendimento.java # Repositório central do sistema
└── Main.java               # Classe principal — demonstração completa
```

---

## 🧬 Hierarquia de Classes

```
Pessoa  (abstrata)
├── Paciente
└── Funcionario  (abstrata)
    ├── Medico          → implements Atendivel
    ├── Enfermeiro      → implements Atendivel
    └── Recepcionista

Consulta  → implements Registravel
Triagem   → implements Registravel
```

---

## ⚙️ Como Executar

**Pré-requisito:** JDK 8 ou superior instalado.

```bash
# 1. Clone o repositório
git clone https://github.com/SEU_USUARIO/sistema-atendimentos-saude.git
cd sistema-atendimentos-saude

# 2. Compile todos os arquivos
javac src/*.java -d out/

# 3. Execute
java -cp out/ Main
```

---

## 🖥️ Exemplo de Saída

```
=================================================
  Sistema de Atendimento - Unimed Natal
  Iniciado com sucesso.
=================================================

[TRIAGEM REGISTRADA] João Pedro Alves em 04/06/2026 08:15
  Risco: 🟠 LARANJA — Muito Urgente (até 10 min)

[CONSULTA #1 REGISTRADA] João Pedro Alves | Dra. Beatriz Nunes | 04/06/2026 09:00

Total de consultas registradas: 3
```

---

## 🔑 Destaques Técnicos

### Polimorfismo via Interface
```java
// Médico e Enfermeiro tratados pelo mesmo tipo
Atendivel[] profissionais = { medicoClinico, enf, medicoCardio };

for (Atendivel prof : profissionais) {
    prof.realizarAtendimento(paciente); // Java decide em tempo de execução
}
```

### Escala de Manchester Simplificada
O método `classificarRisco()` da classe `Triagem` avalia os sinais vitais coletados e classifica o paciente em 5 níveis de urgência:

| Cor | Classificação | Tempo de Atendimento |
|---|---|---|
| 🔴 Vermelho | Emergência | Imediato |
| 🟠 Laranja | Muito Urgente | até 10 min |
| 🟡 Amarelo | Urgente | até 30 min |
| 🟢 Verde | Pouco Urgente | até 60 min |
| 🔵 Azul | Não Urgente | até 120 min |

### Encapsulamento
Todos os atributos são `private`, acessados exclusivamente via getters e setters públicos — garantindo proteção dos dados clínicos sensíveis.

