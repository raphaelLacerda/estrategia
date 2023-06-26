            *> setup the identification division
            IDENTIFICATION DIVISION.
            *> setup the program id
            PROGRAM-ID. HELLO.
            *> setup the procedure division (like 'main' function)
            DATA DIVISION.
              *> working storage defines variables
              WORKING-STORAGE SECTION.
              01 FRASE PIC X(14) VALUE 'UMA ARARA AZUL'.

            PROCEDURE DIVISION.
              *> print a string
              DISPLAY 'ANTES: ' FRASE.
              INSPECT FRASE CONVERTING "AR" TO "ar" AFTER INITIAL " "
              DISPLAY 'DEPOIS: ' FRASE.
            *> end our program
            STOP RUN.