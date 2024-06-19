package br.com.drianodev.migracao_dados_job.writer;

import br.com.drianodev.migracao_dados_job.dominio.Pessoa;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ArquivoPessoasInvalidasWriterConfig {

    @Bean
    FlatFileItemWriter<Pessoa> arquivoPessoasInvalidasWriter() {
        return new FlatFileItemWriterBuilder<Pessoa>()
                .name("arquivoPessoasInvalidasWriter")
                .resource(new FileSystemResource("files/pessoas_invalidas.csv"))
                .delimited()
                .names("id")
                .build();
    }
}
