            IDENTIFICATION DIVISION.
            PROGRAM-ID. VERBS.

            DATA DIVISION.
              WORKING-STORAGE SECTION.
              *> numbers we will perform operations on
              *> with verbs
              01 NUM1 PIC 9(9) VALUE 10.
              01 NUM2 PIC 9(9) VALUE 10.
              01 NUMA PIC 9(9) VALUE 100.
              01 NUMB PIC 9(9) VALUE 15.
              *> variables we will use to store results
              *> of operations we do
              01 NUMC PIC 9(9).
              01 RES-DIV PIC 9(9).
              01 RES-MULT PIC 9(9).
              01 RES-SUB PIC 9(9).
              01 RES-ADD PIC 9(9).
              01 RES-MOV PIC X(9).

            PROCEDURE DIVISION.
              *> compute num1 times num2 and store result in numc
              COMPUTE NUMC = (NUM1 * NUM2).
              *> divide numa by numb and store result in res-div
              DIVIDE NUMA BY NUMB GIVING RES-DIV.
              *> multiply numa by numb storing result in res-mult
              MULTIPLY NUMA BY NUMB GIVING RES-MULT.
              *> subtract numa from numb store result in res-sub
              SUBTRACT NUMA FROM NUMB GIVING RES-SUB.
              *> add numa to numb and store result in res-add
              ADD NUMA TO NUMB GIVING RES-ADD.
              *> the pointer from numa to
              MOVE NUMA TO RES-MOV.
              MOVE 10 TO NUMC.
              ADD NUM1 NUM2 TO NUMC.
              *> reinitilize num1
              INITIALIZE NUM1.
              *> reinitilize num2 but replace numeric data with 12345
              INITIALIZE NUM2 REPLACING NUMERIC DATA BY 12345.
              DISPLAY "NUMC:"NUMC
              DISPLAY "RES-DIV:"RES-DIV
              DISPLAY "RES-MULT:"RES-MULT
              DISPLAY "RES-SUB:"RES-SUB
              DISPLAY "RES-ADD:"RES-ADD
              DISPLAY "RES-MOV:"RES-MOV
              DISPLAY "REINITIALIZED NUM1: "NUM1
              DISPLAY "REINITIALIZED NUM2: "NUM2
              STOP RUN.