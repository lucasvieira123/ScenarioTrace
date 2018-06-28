import java.util.Scanner;

public class Main {
    private static Tracer tracer;

    public static  void main (String [] args){
        tracer = Tracer.getInstance();
        Scanner scanner = new Scanner(System.in);
        Editor editorAtual = null;
        while (true){
            System.out.println("[1]- iniciar o editor");
            System.out.println("[2]- editar o texto");
            System.out.println("[3]- salvar o texto");
            System.out.println("[4]- deletar o texto");
            System.out.println("[5]- sair do editor");
            int opcao = scanner.nextInt();
            tracer.setHMSC("SistemaDeEdicaoDeTexto");

            switch (opcao){
                case 1:
                    editorAtual = new Editor();
                    tracer.setInstanceObject(editorAtual.toString());
                    break;
                case 2:
                    if(editorAtual == null ){
                        System.out.println("editor não inicializado!!");
                    }else {
                        editorAtual.editarTexto();

                        tracer.setBMSC("ediçãoDeTexto")
                                .setComponent(editorAtual.getClass().getSimpleName())
                                .setEvent("editarTexto")
                                .setTime(String.valueOf(System.currentTimeMillis()))
                                .printEventOccorrence();



                    }
                    break;
                case 3:
                    if(editorAtual == null ){
                        System.out.println("editor não inicializado!!");
                    }else {
                        editorAtual.salvarTexto();

                        tracer.setBMSC("salvamentoDeTexto")
                                .setComponent(editorAtual.getClass().getSimpleName())
                                .setEvent("salvarTexto")
                                .setTime(String.valueOf(System.currentTimeMillis()))
                                .printEventOccorrence();
                    }
                    break;
                case 4:
                    if(editorAtual == null ){
                        System.out.println("editor não inicializado!!");
                    }else {
                        editorAtual.deletarTexto();

                        tracer.setBMSC("exclusaoDoTexto")
                                .setComponent(editorAtual.getClass().getSimpleName())
                                .setEvent("deletarTexto")
                                .setTime(String.valueOf(System.currentTimeMillis()))
                                .printEventOccorrence();
                    }
                    break;
                case 5:
                    if(editorAtual == null ){
                        System.out.println("editor não inicializado!!");
                    }else {
                        editorAtual.sairEditor();

                        tracer.setBMSC("saidaDoEditor")
                                .setComponent(editorAtual.getClass().getSimpleName())
                                .setEvent("sairEditor")
                                .setTime(String.valueOf(System.currentTimeMillis()))
                                .printEventOccorrence()
                                .finilizeScenario();
                    }
                    break;
            }

        }
        }








}
