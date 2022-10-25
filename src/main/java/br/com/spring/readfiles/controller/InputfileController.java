package br.com.spring.readfiles.controller;


import br.com.spring.readfiles.inputfiles.InputFileService;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;


@RestController
@RequestMapping("/readfile")
@RequiredArgsConstructor
@Slf4j
public class InputfileController {
    public static final String PLANILHA_MODELO = "src/main/resources/Documents/planilha-fechamento.xlsx";


    private final InputFileService inputFileService;

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("input")
    public void ReadFiles() throws IOException {
        log.info("abrindo arquivo");

        @Cleanup
        Workbook workbook = WorkbookFactory.create(new File(PLANILHA_MODELO));
        Sheet sheet = workbook.getSheetAt(0);
        log.info("chamando service");
        inputFileService.CreateObjs(sheet);


    }
}
