package jp.ac.uryukyu.ie.e205717;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by e205717 on 2016/11/13.
 */
public class Enemy {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }
    /**
     * フィールド変数nameのgetterメソッド。
     */
    public java.lang.String getName(){
        return name;
    }
    /**　
     * フィールド変数nameのsetterメソッド。
     * @param name モンスターの名前。
     */
    public void setName(java.lang.String name){
        this.name = name;
    }
    /**　
     * フィールド変数deadのgetterメソッド。 
     */
    public boolean getDead(){
        return dead;
    }
    /**　
     * フィールド変数deadのsetterメソッド。
     * @param dead 生死判定。
     */
    public void setDead(){
        dead = false;
    }
    /**　
     * フィールド変数hitPointのgetterメソッド。 
     */
    public int getHitpoint(){
        return hitPoint;
    }
    /**　
     * フィールド変数hitPointのsetterメソッド。
     * @param hitPoint 打点。
     */
    public void setHitpoint(int hitPoint){
        this.hitPoint = hitPoint;
    }

    /**
     * Heroへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param hero 攻撃対象
     */
    public void attack(Hero hero){
        if(!dead){
        int damage = (int)(Math.random() * attack);
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, hero.getName(), damage);
        hero.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }

}
