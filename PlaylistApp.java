import java.util.Scanner;

public class PlaylistApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o nome da playlist: ");
        String nome = scan.nextLine();

        Playlist playlistINFO = new Playlist(nome);

        int opcao = -1;

        do {
            System.out.println("\nMENU PLAYLIST");
            System.out.println("[1] Adicionar música");
            System.out.println("[2] Reproduzir música");
            System.out.println("[3] Mostrar status da playlist");
            System.out.println("[0] Sair");
            System.out.print("Escolha uma opção: ");

            if (scan.hasNextInt()) {
                opcao = scan.nextInt();
                scan.nextLine(); // limpar buffer após nextInt
            } else {
                System.out.println("Digite apenas números!");
                scan.nextLine(); // limpar entrada inválida
                continue;
            }

            switch (opcao) {
                case 1:
                    playlistINFO.adicionarMusica();
                    break;
                case 2:
                    playlistINFO.reproduzirMusica();
                    break;
                case 3:
                    playlistINFO.mostrarStatus();
                    break;
                case 0:
                    System.out.println("Saindo da playlist... Obrigado por utilizar nosso aplicativo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scan.close();
    }
}

class Playlist {
    private String nome;
    private int musicaAdic;
    private int musicaRepro;

    public Playlist(String nome) {
        this.nome = nome;
        this.musicaAdic = 0;
        this.musicaRepro = 0;
    }

    public void adicionarMusica() {
        if (musicaAdic < 5000) {
            musicaAdic++;
            System.out.println("Música adicionada! Total de músicas na playlist: " + musicaAdic);
        } else {
            System.out.println("Limite de 5000 músicas atingido, não é possível adicionar mais.");
        }
    }

    public void reproduzirMusica() {
        if (musicaRepro < musicaAdic) {
            musicaRepro++;
            System.out.println("Reproduzindo música número " + musicaRepro + " da playlist.");
        } else {
            System.out.println("Não há músicas para reproduzir no momento.");
        }
    }

    public void mostrarStatus() {
        System.out.println("\nSTATUS DA PLAYLIST");
        System.out.println("Nome da playlist: " + nome);
        System.out.println("Total de músicas adicionadas: " + musicaAdic);
        System.out.println("Total de músicas reproduzidas: " + musicaRepro);
    }
}
