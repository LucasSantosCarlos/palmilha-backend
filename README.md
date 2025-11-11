## 🦶 Palmilha Backend

Projeto backend desenvolvido em **Java (Spring Boot)** para integração com o protótipo de **palmilha eletrônica** voltada ao **monitoramento da pressão plantar** e **análise de padrões de pisada** em corredores.

---

### ⚙️ Passo 1: Baixar o projeto

Clone ou baixe o projeto diretamente do repositório oficial:  
🔗 [https://github.com/LucasSantosCarlos/palmilha-backend](https://github.com/LucasSantosCarlos/palmilha-backend)

Você pode fazer isso de duas formas:

- **Via Git (recomendado):**

  ```bash
  git clone https://github.com/LucasSantosCarlos/palmilha-backend.git
  ```

- **Ou baixando o ZIP:**
  
  Clique em **“Code” → “Download ZIP”** e extraia o projeto em sua máquina.

---

### 🗄️ Passo 2: Instalar o PostgreSQL

Instale o **PostgreSQL 17** em seu computador.  
Durante a instalação, anote a **porta configurada** — por padrão é **5432**.

Essas informações serão usadas posteriormente na configuração do arquivo `application.properties`.

---

### 🧩 Passo 3: Criar o banco de dados

Acesse o **pgAdmin** ou outro cliente SQL e crie um banco chamado:

```sql
CREATE DATABASE palmilha;
```

Não é necessário criar tabelas manualmente:  
O **Liquibase**, já configurado no projeto, fará a criação automática das estruturas ao iniciar a aplicação.

---

### 💻 Passo 4: Instalar e configurar o IntelliJ IDEA

Recomenda-se o uso do **IntelliJ IDEA** (Community ou Ultimate), que oferece integração nativa com Maven, Lombok e Spring Boot.

1. Abra o IntelliJ.  
2. Vá em **File → Open** e selecione a pasta `palmilha-backend`.  
3. Aguarde o download automático das dependências.

---

### 🔐 Passo 5: Configurar o banco de dados

No arquivo `src/main/resources/application.properties`, ajuste os seguintes parâmetros conforme o seu ambiente local:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/palmilha
spring.datasource.username=postgres
spring.datasource.password=sua_senha
```

---

### ☕ Passo 6: Selecionar a versão do Java

Certifique-se de que o projeto está configurado para usar a **versão 17 do Java**, garantindo compatibilidade com as dependências e o Spring Boot.

No IntelliJ:  
`File → Project Structure → Project SDK → 17`

---

### 🧠 Passo 7: Instalar o plugin Lombok

O projeto utiliza **Lombok** para geração automática de getters, setters, construtores, etc.

Instale o plugin no IntelliJ:

- Vá em **File → Settings → Plugins → Marketplace**
- Pesquise por **Lombok**
- Clique em **Install** e reinicie o IntelliJ

Mais informações:  
🔗 [https://projectlombok.org/setup/intellij](https://projectlombok.org/setup/intellij)

---

### ▶️ Passo 8: Iniciar o projeto

No IntelliJ, abra o arquivo principal:

```
src/main/java/com/example/PalmilhaBackendApplication.java
```

Clique no botão verde de **Run** ▶️ para iniciar a aplicação.  
O backend estará disponível em:  
👉 `http://localhost:8080`

---
