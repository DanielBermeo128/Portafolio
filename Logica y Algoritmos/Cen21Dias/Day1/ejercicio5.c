// Deberia de crear un documento y escribir en el pero por compatibilidad no jala aun
// RECHECAR EN EL FUTURO
#include<stdio.h>

void do_heading(char *filename);
int line , page;

main(int argv, char *argc[]){

    char buffer[256];
    FILE *fp;

    if(argv<2){
        fprintf(stderr, "\nProper Usage is: ");
        fprintf(stderr, "\n\nPRINT_IT filename.ext\n");
        exit(1);
    }

    if((fp = fopen(argc[1],"w"))==NULL){
        fprintf(stderr, "Error opening file, %s",argc[1]);
        exit(1);
    }

    page = 0;
    line = 1;
    do_heading(argc[1]);

    while(fgets(buffer,256,fp) != NULL){
        if(line % 55 == 0)
            do_heading(fp);
            // Posible error de compilador, el ejemplo usa stdprn que no esta disponible aca
            fprintf(fp,"%4d\t%s",line++,buffer);
    }

    fprintf(fp,"\f");
    fclose(fp);
    return 0;
}

void do_heading(char *filename){
    page ++;
    if(page>1)
        fprintf(filename,"\f");
    fprintf(filename,"Page: %d, %s\n\n",page,filename);
}