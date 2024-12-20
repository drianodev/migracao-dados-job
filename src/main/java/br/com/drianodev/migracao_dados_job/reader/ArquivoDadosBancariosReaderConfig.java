package br.com.drianodev.migracao_dados_job.reader;

import br.com.drianodev.migracao_dados_job.dominio.DadosBancarios;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ArquivoDadosBancariosReaderConfig {
    @Bean
    FlatFileItemReader<DadosBancarios> dadosBancariosReader() {
        return new FlatFileItemReaderBuilder<DadosBancarios>()
                .name("dadosBancariosReader")
                .resource(new FileSystemResource("files/dados_bancarios.csv"))
                .delimited()
                .names("pessoaId", "agencia", "conta", "banco", "id")
                .addComment("--")
                .saveState(false)
                .targetType(DadosBancarios.class)
                .build();
    }
}