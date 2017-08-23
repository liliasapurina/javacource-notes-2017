package heroes;

public class Main {
    public static void main(String[] args) {
        CharacterFactory characterFactory = new CharacterFactory();
        GameManager gameManager = new GameManager();

        Character c1 = characterFactory.createCharacter();
        Character c2 = characterFactory.createCharacter();

        System.out.println("***********************************************************************************");
        System.out.println(c1.getHeroType() + " " + c1.getName() + " VS " + c2.getHeroType() + " " + c2.getName());
        System.out.println("***********************************************************************************" + "\n");

        gameManager.fight(c1, c2);
    }
}
