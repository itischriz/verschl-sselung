package ckuellinger.cipher;

public class MonoAlphabeticCipher {
    private String secretAlphabet;
    protected String ALPHABET = "abcdefghijklmnopqrstuvwxyzäöüß";
    /**
     * Konstruktor für MonoAlphabeticCipher.
     * Initialisiert das Geheimalphabet mit dem Standardalphabet (kein Verschlüsselungseffekt).
     */
    public MonoAlphabeticCipher() {
        this.secretAlphabet = this.ALPHABET;
    }
    /**
     * Gibt das aktuelle Geheimalphabet zurück, welches zur Verschlüsselung verwendet wird.
     *
     * @return Das Geheimalphabet als String.
     */
    public String getSecretAlphabet() {
        return this.secretAlphabet;
    }
    /**
     * Setzt das Geheimalphabet auf den angegebenen Wert.
     * Diese Methode kann von Subklassen verwendet werden, um das Geheimalphabet zu modifizieren.
     *
     * @param secretAlphabet Das neue Geheimalphabet.
     */
    protected void setSecretAlphabet(String secretAlphabet) {
        if(secretAlphabet == null) {
        	throw new NullPointerException("Ein Text ohne Wert!");
        }
        this.secretAlphabet = secretAlphabet;
    }
    /**
     * Verschlüsselt den übergebenen Text mithilfe des Geheimalphabets.
     * Nicht im Alphabet enthaltene Zeichen werden unverändert übernommen.
     *
     * @param text Der zu verschlüsselnde Text.
     * @return Der verschlüsselte Text.
     */
    public String encrypt(String text) {
        if(text == null) {
        	throw new NullPointerException("Ein Text ohne Wert!");
        }
        StringBuilder result = new StringBuilder();
        text = text.toLowerCase();

        for(char c : text.toCharArray()) {
            int index = ALPHABET.indexOf(c);
            if(index != -1) {
            	result.append(secretAlphabet.charAt(index));
            }
            else result.append(c);
        }
        return result.toString();
    }
    /**
     * Entschlüsselt den übergebenen Text mithilfe des Geheimalphabets.
     * Nicht im Geheimalphabet enthaltene Zeichen werden unverändert übernommen.
     *
     * @param text Der zu entschlüsselnde Text.
     * @return Der entschlüsselte Text.
     */
    public String decrypt(String text) {
        if(text == null) {
        	throw new NullPointerException("Ein Text ohne Wert!");
        }
        StringBuilder result = new StringBuilder();
        text = text.toLowerCase();

        for(char c : text.toCharArray()) {
            int index = secretAlphabet.indexOf(c);
            //Wenn Zeichen nicht gefunden wird = -1
            if(index != -1){
            	result.append(ALPHABET.charAt(index));
            }
            else result.append(c);
        }
        return result.toString();
    }
    /**
     * Gibt eine Beschreibung der Verschlüsselungsmethode zurück.
     *
     * @return Eine Beschreibung der aktuellen Verschlüsselung (in diesem Fall "Keine Verschlüsselung!").
     */
    public String getDescription() {
        return "Keine Verschlüsselung!";
    }
}
