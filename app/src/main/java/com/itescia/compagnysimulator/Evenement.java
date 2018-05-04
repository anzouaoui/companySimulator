package com.itescia.compagnysimulator;

/**
 * Created by gbon on 04/05/2018.
 */

/**
 * <b> Classe représentant les évènements</b>
 *
 * @author gbon
 */
public class Evenement {

    /** L'identifiant de l'évènement
     * @see Evenement#getNumero()
     *
     * @author gbon
     */
    private int numero;

    /** Le message de l'évènement à afficher
     * @see Evenement#getMessage()
     *
     * @author gbon
     */
    private String message;

    /** Le message du bouton 1
     * @see Evenement#getMessageChoix1() ()
     *
     * @author gbon
     */
    private String messageChoix1;

    /** Le message du bouton 2
     * @see Evenement#getMessageChoix2() ()
     *
     * @author gbon
     */
    private String messageChoix2;

    /**
     * Permet de créer un nouvel évènement
     *
     * @param numero: le numéro de l'évènement à créer (event dû à une action du joueur: 1-100/event aléatoire: 101-...)
     * @param message : le message qui sera affiché (description de l'évènement)
     * @param messageChoix1 : le choix 1(nom du bouton du choix 1)
     * @param messageChoix2 : le choix 2(nom du bouton du choix 2)
     *
     * @author gbon
     */
    public Evenement(int numero, String message, String messageChoix1, String  messageChoix2){
        this.numero = numero;
        this.message = message;
        this.messageChoix1 = messageChoix1;
        this.messageChoix2 = messageChoix2;
    }

    /**
     * Getters :
     */
    public int getNumero() { return numero; }
    public String getMessage() { return message; }
    public String getMessageChoix1() { return messageChoix1; }
    public String getMessageChoix2() { return messageChoix2; }
}
