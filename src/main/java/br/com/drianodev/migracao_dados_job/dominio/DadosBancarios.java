package br.com.drianodev.migracao_dados_job.dominio;

import lombok.Data;

@Data
public class DadosBancarios {

    private int id;
    private int pessoaId;
    private int agencia;
    private int conta;
    private int banco;
}
