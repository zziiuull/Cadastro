package com.example.cadastro

data class Formulario(
    val nome: String,
    val telefone: String,
    val email: String,
    val recebeEmails: Boolean,
    val sexo: String,
    val cidade: String,
    val uf: String
){
    override fun toString(): String {
        return "Nome: $nome\n" +
                "Telefone: $telefone\n" +
                "Email: $email\n" +
                "Recebe E-mails: ${if (recebeEmails) "Sim" else "Não"}\n" +
                "Sexo: $sexo\n" +
                "Cidade: $cidade\n" +
                "UF: $uf"
    }
}
