
package swimsoft;

import java.util.Scanner;


public class Deportista {
    Scanner lector = new Scanner(System.in);  
    int contUser=0, cod=1, contUser2=0,cod2=1; //variable llevar control usuarios ingresados
    SwimSoft usuario [] = new SwimSoft[100]; //creando el arreglo de objetos (clase userBanc
    Competeencia usuario2 []= new Competeencia[100];
    //MODULO 1 INSCRIPCION DEPORTISTAS
        
        //MENU PRINCIPAL
    
        public void Gestion_Deportista(){
                
                int op;
                do{
                    System.out.print("1.Ingresar deportista \n");
                    System.out.print("2.Actualizar deportista \n");
                    System.out.print("3.Eliminar deportista \n");
                    System.out.print("4.Buscar deportista \n");
                    System.out.print("5.Salir \n");
                    op=lector.nextInt();
                    switch(op){
                            case 1:
                                Ingresar_Deportista();
                                break;
                            case 2:
                                Actualizar_Deportista();
                                break;
                            case 3:
                                Eliminar_Deportista();
                                break;
                            case 4:
                                Buscar_Deportista();
                            case 5:
                                break;
                            default:
                                System.out.print("NO ES UNA OPCIÓN VÁLIDA \n");
                    }
                }while(op!=5);

        }
        
        //INSCRIPCION
        
        public void Ingresar_Deportista(){

            String nombre,rama;
            int doc,fecNac,ano,categoria=0;
            SwimSoft temp = new SwimSoft();

            nombre=lector.nextLine();
            System.out.println("Nombre:");
            nombre=lector.nextLine();
            System.out.println("Rama(Masculino/Femenino):");
            rama=lector.nextLine();
            System.out.println("Numero de documento:");
            doc=lector.nextInt();
            System.out.println("Año de nacimiento:");
            fecNac=lector.nextInt();
            
            temp.setNombre(nombre); 
            temp.setRama(rama); 
            temp.setDocumento(doc);
            temp.setFecNac(fecNac);
            ano=2016-fecNac;
            if((ano >= 6) && (ano <= 10)){
                categoria=1;
            }
            else if((ano >= 11)&&(ano <= 17)){
                categoria=2;
            }
            else if((ano >= 18)&&(ano <= 25)){
                categoria=3;
            }
            else if(ano > 25){
                categoria=4;
            }
            else {
                System.out.print("EL PARTICIPANTE NO TIENE EDAD PARA COMPETIR");
            }
            
            temp.setCategoria(categoria);
            usuario[contUser] = temp;
            contUser++;  
            cod++;  
        }
        
        //ACTUALIZAR
        public void Actualizar_Deportista(){
     
            int codigo;
            String nombre,rama;
            int doc,fecNac,ano,categoria=0;
            System.out.print("Ingrese numero de documento:");
            codigo=lector.nextInt();

            if(contUser!=0){
                for(int i=0; i<contUser; i++){
                    if(usuario[i].getDocumento() == codigo){
                        nombre=lector.nextLine();
                            System.out.println("Nombre:");
                            nombre=lector.nextLine();
                            System.out.println("Rama(Masculino/Femenino):");
                            rama=lector.nextLine();
                            System.out.println("Numero de documento:");
                            doc=lector.nextInt();
                            System.out.println("Año de nacimiento:");
                            fecNac=lector.nextInt();

                            usuario[i].setNombre(nombre); 
                            usuario[i].setRama(rama); 
                            usuario[i].setDocumento(doc);
                            usuario[i].setFecNac(fecNac);
                            ano=2016-fecNac;
                            if((ano >= 6) && (ano <= 10)){
                                categoria=1;
                            }
                            else if((ano >= 11)&&(ano <= 17)){
                                categoria=2;
                            }
                            else if((ano >= 18)&&(ano <= 25)){
                                categoria=3;
                            }
                            else if(ano > 25){
                                categoria=4;
                            }
                            else {
                                System.out.print("EL PARTICIPANTE NO TIENE EDAD PARA COMPETIR");
                            }

                            usuario[i].setCategoria(categoria);
                            break;
                    }
                    else{
                        System.out.print("No se ha encontrado el usuario");
                        break;
                    }
                }
            }           

        }
    
        //ELIMINAR
        public void Eliminar_Deportista(){
        int codigo,bandera=0;
        SwimSoft alumTemp[] = new SwimSoft[contUser-1];//creando un arreglo temporal con un campo menos
        System.out.print("Ingrese numero de documento:");
        codigo=lector.nextInt();
                         for(int i=0; i<contUser; i++){ //Inicio ciclo para realizar la eliminacion
                                if(codigo == usuario[i].getDocumento()){ //si el codigo a aliminar coincide con el codigo que hay en la posicion i
                                    usuario[i].categoria=0;
                                    usuario[i].doc=0;
                                    usuario[i].nombre="";
                                    usuario[i].rama="";
                                    usuario[i].fecNac=0;
                                    System.out.println("Se ha eliminado el usuario");
                                    bandera=1;
                                    break;
                                }
        }
         if(bandera==0){
         
             System.out.println("usuario no encontrado");
         }
        }
        
        //BUSCAR
        public void Buscar_Deportista(){
            
            int codigo;
            
            System.out.print("Ingrese numero de documento:");
            codigo=lector.nextInt();

            if(contUser!=0){
                for(int i=0; i<contUser; i++){
                    if(usuario[i].getDocumento() == codigo){
                            System.out.println("Nombre: " +usuario[i].getNombre());
                            System.out.println("Rama: " +usuario[i].getRama());
                            System.out.println("Numero de documento: " +usuario[i].getDocumento());
                            System.out.println("Fecha de nacimiento: " +usuario[i].getFecNac());
                            if(usuario[i].getCategoria() == 1){
                                System.out.println("Categoria: Infantil A");
                            }
                            else if(usuario[i].getCategoria() == 2){
                                System.out.println("Categoria: Infantil B");
                            }
                            else if(usuario[i].getCategoria() == 3){
                                System.out.println("Categoria: Juvenil");
                            }
                            else if(usuario[i].getCategoria() == 4){
                                System.out.println("Categoria: Senior");
                            }
                        break;
                    }
                    else{
                        System.out.print("No se ha encontrado el usuario");
                        break;
                    }
                }
            }           
        }
        
    //MODULO 2 INSCRIPCION COMPETENCIAS    
        
        public void Inscripcion_Competencia(){    
                int op;
                do{
                    System.out.print("1.Inscribir \n");
                    System.out.print("2.Eliminar de una preuba \n");
                    System.out.print("3.Mostrar prueba \n");
                    System.out.print("4.Salir \n");
                    op=lector.nextInt();
                    switch(op){
                            case 1:
                                Inscribir();
                                break;
                            case 2:
                                Eliminar_Prueba();
                                break;
                            case 3:
                                Mostrar_Prueba();
                                break;
                            case 4:
                                break;
                            default:
                                System.out.print("NO ES UNA OPCIÓN VÁLIDA \n");
                    }
                }while(op!=4);
        }
        
        //INSCRIBIR
         
        public void Inscribir(){
            
            int codigo,prueba;
            
            String categoria;
            System.out.print("Ingrese numero de documento:");
            codigo=lector.nextInt();
            Competeencia temp2 = new Competeencia();

            if(contUser!=0){
                for(int i=0; i<contUser; i++){
                    if(usuario[i].getDocumento() == codigo){
                        do{
                            
                            System.out.print("PRUEBAS DE 50 MTS \n");
                            System.out.print("1.Libre \n");
                            System.out.print("2.Mariposa \n");
                            System.out.print("3.Pecho \n");
                            System.out.print("4.Espalda \n");
                            System.out.print("5.Salir \n");
                            prueba=lector.nextInt();
                            
                            switch(prueba){
                                    case 1:
                                        temp2.setLibre(usuario[i].getDocumento());
                                        break;
                                    case 2:
                                        temp2.setMariposa(usuario[i].getDocumento());
                                        break;
                                    case 3:
                                        temp2.setPecho(usuario[i].getDocumento());
                                        break;
                                    case 4:
                                        temp2.setEspalda(usuario[i].getDocumento());
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        System.out.print("NO ES UNA OPCIÓN VÁLIDA \n");
                            }
                            usuario2[contUser2] = temp2;
                            contUser2++;  
                            cod2++;  
                        }while(prueba!=5);
                        break;
                    }
                    else{
                        System.out.print("No se ha encontrado el usuario");
                        break;
                    }
                }
            }    
        }
        
        //ELIMINAR PRUEBA
        
        public void Eliminar_Prueba(){
            int codigo,prueba,bandera=0;
        Competeencia temp2[] = new Competeencia[contUser-1];//creando un arreglo temporal con un campo menos
        //SwimSoft temp3[] =new SwimSoft[contUser-1];
        System.out.print("Ingrese numero de documento:");
        codigo=lector.nextInt();
for(int i=0; i<contUser; i++){ //Inicio ciclo para realizar la eliminacion
                                if(codigo == usuario[i].getDocumento()){ //si el codigo a aliminar coincide con el codigo que hay en la posicion i
                                     do{
                            
                            System.out.print("PRUEBAS DE 50 MTS \n");
                            System.out.print("1.Libre \n");
                            System.out.print("2.Mariposa \n");
                            System.out.print("3.Pecho \n");
                            System.out.print("4.Espalda \n");
                            System.out.print("5.Salir \n");
                            prueba=lector.nextInt();
                            
                            switch(prueba){
                                    case 1:
                                        usuario2[i].libre=0;
                                         System.out.println("Se ha eliminado la competencia libre");
                                        break;
                                    case 2:
                                        usuario2[i].mariposa=0;
                                        System.out.println("Se ha eliminado la competencia mariposa");
                                        break;
                                    case 3:
                                        usuario2[i].pecho=0;
                                        System.out.println("Se ha eliminado la competencia pecho");
                                        break;
                                    case 4:
                                         usuario2[i].espalda=0;
                                         System.out.println("Se ha eliminado la competencia espalda");
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        System.out.print("NO ES UNA OPCIÓN VÁLIDA \n");
                            }
                                    bandera=1;
                                    break;
                                }while(prueba != 5);
        }
         if(bandera==0){
         
             System.out.println("usuario no encontrado");
         }
                        
        }
        }
        //MOSTRAR PRUEBA
        
        public void Mostrar_Prueba(){
            /*int prueba;
            int[] sen,iA,iB,juv;
            String[] pecho,espalda,mariposa,libre;
            int contiA=0,contiB=0,contj=0,conts=0,contl=0,conte=0,contp=0,contm=0;
            iA= new int[100];
            iB= new int[100];
            juv= new int[100];
            sen= new int[100];
            
            pecho= new String[100];
            espalda= new String[100];
            mariposa= new String[100];
            libre= new String[100];
            if(contUser!=0){
                for(int i=0; i<contUser; i++){
                    if(usuario[i].getCategoria() == 1){
                        iA[contiA]=usuario[i].getDocumento();
                        contiA++;
                    }
                    else if(usuario[i].getCategoria()==2){
                        iB[contiB]=usuario[i].getDocumento();
                        contiB++;
                    }
                    else if(usuario[i].getCategoria()==3){
                        juv[contj]=usuario[i].getDocumento();
                        contj++;
                    }
                    else if(usuario[i].getCategoria()==4){
                        sen[conts]=usuario[i].getDocumento();
                        conts++;
                    }
                    
                    for(int j=0;j<100;j++){
                        for(int k=0;k < usuario.length;k++){
                            if(usuario[k].getDocumento() == iA[j]  ){
                                libre[contl]=usuario[k].getNombre();
                                contl++;
                            }
                            else
                        }
                    }
                    for(int j=0;j<iB.length;j++){
                                            for(int k=0;k < usuario.length;k++){
                                                    if(usuario[k].getDocumento() == iB[j]  ){
                                                        libre[contl]=usuario[k].getNombre();
                                                        contl++;
                                                    }
                                            }
                                        }
                    for(int j=0;j<iA.length;j++){
                                            for(int k=0;k < usuario.length;k++){
                                                    if(usuario[k].getDocumento() == iA[j]  ){
                                                        libre[contl]=usuario[k].getNombre();
                                                        contl++;
                                                    }
                                            }
                                        }
                    for(int j=0;j<iA.length;j++){
                                            for(int k=0;k < usuario.length;k++){
                                                    if(usuario[k].getDocumento() == iA[j]  ){
                                                        libre[contl]=usuario[k].getNombre();
                                                        contl++;
                                                    }
                                            }
                                        }
                        do{
                            
                            System.out.print("PRUEBAS DE 50 MTS \n");
                            System.out.print("1.Libre \n");
                            System.out.print("2.Mariposa \n");
                            System.out.print("3.Pecho \n");
                            System.out.print("4.Espalda \n");
                            prueba=lector.nextInt();
                            
                            switch(prueba){
                                    case 1:
                                        for(j=0;j<libre.length;j++){
                                            
                                        }
                                        break;
                                        
                                    case 2:
                            
                                        break;
                                    case 3:
                            
                                        break;
                                    case 4:
                            
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        System.out.print("NO ES UNA OPCIÓN VÁLIDA \n");
                            }
                        }while(prueba!=5);*/
        }
        
    //MENU PRINCIPAL    
        
    public static void main(String[] args) {
        Deportista persona = new Deportista();
        int modulo;
        Scanner lector = new Scanner(System.in);  
            do{
            System.out.print("1.Gestión de deportistas \n");
            System.out.print("2.Inscripción en competencia \n");
            System.out.print("3.Salir \n");
            modulo=lector.nextInt();
            switch(modulo){
                        case 1:
                            persona.Gestion_Deportista();
                            break;
                        case 2:
                            persona.Inscripcion_Competencia();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.print("NO ES UNA OPCIÓN VÁLIDA \n");
            }
            }while(modulo!=3);
    }
}


