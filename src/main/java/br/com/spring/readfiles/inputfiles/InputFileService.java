package br.com.spring.readfiles.inputfiles;


import br.com.spring.readfiles.beans.Departamento;
import br.com.spring.readfiles.beans.Funcionario;
import br.com.spring.readfiles.inputfiles.repositories.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;

@Service
@RequiredArgsConstructor
@Slf4j
public class InputFileService {

    private static final int COLUNA_SALARIO = 2;
    private static final int COLUNA_NOME_FUNCIONARIO = 1;
    private static final int COLUNA_DEPARTAMENTO = 0;

    private final DepartamentoRepository departamentoRepository;


    public void CreateObjs(Sheet sheet) throws IOException {
        Departamento departamento = new Departamento();
        Funcionario funcionario = new Funcionario();

        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (row.getRowNum() == 0) {
                continue;
            }

            if (rowIterator.hasNext()) ;
            String nomedep = row.getCell(COLUNA_DEPARTAMENTO).getStringCellValue();

            departamento = departamentoRepository.findFirstByNome(nomedep);
            if (ObjectUtils.isEmpty(departamento)) {
                departamento = Departamento.builder()
                        .nome(nomedep).build();
            }


            String nomefunc = row.getCell(COLUNA_NOME_FUNCIONARIO).getStringCellValue().toUpperCase();
            BigDecimal salario = BigDecimal.valueOf(row.getCell(COLUNA_SALARIO).getNumericCellValue());
            funcionario = Funcionario.builder()
                    .nome(nomefunc)
                    .departamento(departamento)
                    .salario(salario)
                    .build();
            departamento.getFuncionario().add(funcionario);

            log.info("persistindo dados");
            departamento = departamentoRepository.save(departamento);


        }

    }
}
