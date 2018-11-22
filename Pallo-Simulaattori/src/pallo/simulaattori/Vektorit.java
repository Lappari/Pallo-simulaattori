/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pallo.simulaattori;

import java.awt.Color;
import java.awt.Graphics;


/**
 *
 * @author Janari
 */
public class Vektorit {
    
    private double x, y;
    private Color vari;
    
    public Vektorit(double x, double y, Color vari){
    
    this.x = x;
    this.y = y;
    this.vari = vari;
    }
    
    public double getX() {
    return x;}
    
    public void setX(double x) {
    this.x = x;}
    
    public double getY(){
    return y; }
    
    public void setY(double y){
    this.y = y; }
    
    public void kasvataX(double x){
    this.x += x; }
    
    public void kasvataY(){
    this.y += y; }
    
    public Vektorit lisaa(Vektorit v, Color vari){
    return new Vektorit(x + v.x, y + v.y, vari); }
    
    public Vektorit vahenna(Vektorit v, Color vari){
    return new Vektorit(x - v.x, y - v.y, vari); }
    
    public void kerro(double k){
    x *= k;
    y *= k;}
    
    public void setKoko(double koko) {
    normalisoi();
    kerro(koko); }
    
    public double getKoko(){
    return Math.sqrt(x * x + y * y); }
    
    public void normalisoi() {
    double intensiteetti = getKoko();
    x /= intensiteetti;
    y /= intensiteetti; }
    
    public double piste(Vektorit v){
    return x * v.x + y * v.y;
    }
    
    public void kaanny(double kulma) {
    double s = Math.sin(kulma);
        double c = Math.cos(kulma);

        double newX = x * c - y * s;
        double newY = x * s + y * c;

        x = newX;
        y = newY;}
    
    public double getKulma(){
    return Math.atan2(x, y); }
    
    public double getSuhteellinenkulma(Vektorit v){
    return getMerkki(v) * Math.acos(piste(v) / (getKoko())); }
    
    public int getMerkki(Vektorit v) {
    return (y*v.x > x*v.y)?-1:1; }
    
    public Vektorit valmista() {
    return new Vektorit(-getY(), getX(), vari); }
    
    public double valmistaPiste(Vektorit v){
    return valmista().piste(v); }
    
    public void piirra(Graphics g, Vektorit vastine) {
    g.setColor(vari);
    g.drawLine((int) vastine.x, (int) vastine.y, (int) (vastine.x + x), (int) (vastine.y + y)); }
    
}
