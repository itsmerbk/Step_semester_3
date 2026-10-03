package week7.assignment_problems;
public abstract class GameCharacter {
    private static int counter = 0;
    private final String characterId;
    public GameCharacter() {
        counter++;
        this.characterId = "CHAR-" + counter;
    }
    public abstract String getSpecialMove();
    public String getCharacterId() { return characterId; }
}
