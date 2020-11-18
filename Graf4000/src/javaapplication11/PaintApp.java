package javaapplication11;

import java.awt.*;
import javax.swing.*;

public class PaintApp extends JFrame{
    //метод после изменения комбобокса(выбор функции)
    private void cbModelItemStateChanged(java.awt.event.ItemEvent evt) {                                            
        if (cb.getSelectedIndex() == 0) {
            pg.repaint();
            check=0;
        } else {
            pg.repaint();
           check=1;
        }
    }
    //метод после изменения jtext1(Мин Х)
    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {                                        
        try{
            minx =  Double.parseDouble(text1.getText());
            if (minx>=maxx) {JOptionPane.showMessageDialog(null,"Минимальный х не может быть больше чем максимальный","Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            else
            {pg.repaint();}       
        }catch(Exception ex){
        }
    }
    //метод после изменения jtext2(Мин У)
    private void jTextField2CaretUpdate(javax.swing.event.CaretEvent evt) {                                        
        try{
            miny =  Double.parseDouble(text2.getText());
            if (miny>=maxy) {JOptionPane.showMessageDialog(null, "Минимальный y не может быть больше чем максимальный","Ошибка", JOptionPane.ERROR_MESSAGE);  
            }
            else
            {pg.repaint(); } 
            
        }catch(Exception ex){
        }
    }
    //метод после изменения jtext3(Макс Х)
    private void jTextField3CaretUpdate(javax.swing.event.CaretEvent evt) {                                        
        try{
            maxx =  Double.parseDouble(text3.getText());
            if (minx>=maxx) {JOptionPane.showMessageDialog(null, "Минимальный x не может быть больше или равен максимальному","Ошибка", JOptionPane.ERROR_MESSAGE);  
            }
            else
            {pg.repaint(); }
        }catch(Exception ex){
        }
    }
    //метод после изменения jtext4(Макс У)
     private void jTextField4CaretUpdate(javax.swing.event.CaretEvent evt) {                                        
        try{
            maxy =  Double.parseDouble(text4.getText());
            if (miny>=maxy) {JOptionPane.showMessageDialog(null, "Минимальный y не может быть больше или равне максимальному","Ошибка", JOptionPane.ERROR_MESSAGE);  
            }
            else
            {pg.repaint(); }   
        }catch(Exception ex){
        }
    }
     //метод после изменения jtext5(шаг по Х)
     private void jTextField5CaretUpdate(javax.swing.event.CaretEvent evt) {                                        
        try{
            shx =  Double.parseDouble(text5.getText());
            if (shx!=0) {
              pg.repaint();  
            }
        }catch(Exception ex){
        }
    }
     //метод после изменения jtext6(шаг по У)
     private void jTextField6CaretUpdate(javax.swing.event.CaretEvent evt) {                                        
        try{
            shy =  Double.parseDouble(text6.getText());
            if (shy!=0) {
              pg.repaint();  
            }
        }catch(Exception ex){
        }
    }
     //cоздаем переменные и панели,которые нам нужно иметь всегда
    PaintGraph pg;
    int check=0;
    double minx=-20;
    double miny=-10;
    double maxx=20;
    double maxy=10;
    double shx=5;
    double shy=1;
    JComboBox<String> cb;
    JTextField text1 = new JTextField("-20");
    JTextField text2 = new JTextField("-10");
    JTextField text3 = new JTextField("20");
    JTextField text4 = new JTextField("10");
    JTextField text5 = new JTextField("5");
    JTextField text6 = new JTextField("1");
    public PaintApp() {
        //главный метод и создание фремка
        pg = new PaintGraph();
        setTitle("отображатор графиков 4000");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 500);
        //Создаем объект панели, на котором будет отображаться грфик
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        JPanel panel1 = new JPanel();
        panel1.setMaximumSize(new Dimension(150,10000));
        //иницилизируем комбобокс и его внутренности
        cb = new JComboBox<String>();
        cb.addItem("cos2x*e^(sinx)");
        cb.addItem("sinx");
        //создаем несохраняемые панели
        JLabel label1 =new JLabel(" выберите функцию");
        JLabel label2 =new JLabel("__________________");
        JLabel label3 =new JLabel(" Минимальный X");
        
        JLabel label4 =new JLabel("Минимальный Y");
        JLabel label5 =new JLabel("                  ");
        JLabel label6 =new JLabel("Максимальный X");
        JLabel label7 =new JLabel("Максимальный Y");
        JLabel label8 =new JLabel("Введите шаг по X");
        JLabel label9 =new JLabel("Введите шаг по Y");
        //размещаем их по гриду
        panel1.setLayout(new GridLayout(18,1));
        panel1.add(label1);panel1.add(cb);panel1.add(label2);panel1.add(label3);
        panel1.add(text1);panel1.add(label4);panel1.add(text2);panel1.add(label5);
        panel1.add(label6);panel1.add(text3);panel1.add(label7);panel1.add(text4);
        panel1.add(label2);panel1.add(label8);panel1.add(text5);panel1.add(label9);
        panel1.add(text6);
        //создаем тригер апдейда для text1
        text1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField1CaretUpdate(evt);
            }
        });
        //создаем тригер апдейда для text2
        text2.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField2CaretUpdate(evt);
            }
        });
        //создаем тригер апдейда для text31
        text3.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField3CaretUpdate(evt);
            }
        });
        //создаем тригер апдейда для text4
        text4.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField4CaretUpdate(evt);
            }
        });
        //создаем тригер апдейта для text5
        text5.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField5CaretUpdate(evt);
            }
        });
        //создаем триггер апдеейта для text6
        text6.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField6CaretUpdate(evt);
            }
        });
        //а это для боксмастера
        cb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbModelItemStateChanged(evt);
            }
            });
        panel.add(pg);
        //Добавляем label1 в panel
        panel.add(panel1);
        //Дабавляем панель на главное окно
        add(panel);
        //Делаем окно по центру
        setLocationRelativeTo(null);
        //Делаем минимальные размер окна
        setMinimumSize(new Dimension(300,300));
        //Делаем видимым главное окно
        setVisible(true);
    }
//старт
 public static void main(String args[])
         
 {   
     new PaintApp();
 }

//в этом классе все что взяанно с холстом
class PaintGraph extends JPanel
{
//переменные
int check=0;
 private int Wth, Hig;
 private double zy;
 private double zx;
 private int CX,CY;
 private final double Pi;
 private Font curFont;
 private FontMetrics curFontMetrics;
 //создание графа
 public PaintGraph()
 {
  Pi=Math.PI;
  setBackground(Color.black);
  curFont=getFont();
  curFontMetrics=getFontMetrics(curFont);
 }

//методы которые изменяют изначальное отбражение всего
//стандартно начало координат левый верхний угол
//здесь же начало координат-центр холста,центр динамические изменяется из-за maxx maxy minx miny
 private int CX(double x,double z,double k){
  return (int)((Wth/2)+((x/(z-k))*Wth)-2-Wth*(1-((z/2-3*k/2)/(z-k)))); 
 }  
 
 private int CY(double y,double z,double k)
 {
  return (int)((Hig/2)+((y/(z-k)*Hig)+Hig*(1-((z/2-3*k/2)/(z-k)))));
 }
 //в этом методе рисуем оси метки
 public void paint(Graphics g)
 {
  super.paint(g);
    //получим размеры области рисования
  Wth=getSize().width;
  Hig=getSize().height;
  double Vodx=shx;
  double Kolx=maxx/Vodx;
  double Kolxm=minx/Vodx;
  double Vody=shy;
  double Koly=maxy/Vody;
  double Kolym=miny/Vody;
    //устанавливаем цвет
  g.setColor(Color.white);
  
    //рисуем правую часть меток оси х.

     for (double i =0 ; i <=-Kolxm;i++) {
         double n = -i*Vodx;
        String name=""+n;
     g.drawLine(CX(-i*Vodx,maxx,minx), CY(maxy/50,maxy,miny),CX(-i*Vodx,maxx,minx), CY(-maxy/50,maxy,miny));
     g.drawString(name,CX(-i*Vodx,maxx,minx) ,CY(maxy/20,maxy,miny) );
     }
     //левую
     for (double i =0 ; i <=Kolx;i++) {
         double n = i*Vodx;
        String name=""+n;
     g.drawLine(CX(i*Vodx,maxx,minx), CY(maxy/50,maxy,miny),CX(i*Vodx,maxx,minx), CY(-maxy/50,maxy,miny));
     g.drawString(name,CX(i*Vodx,maxx,minx) ,CY(maxy/20,maxy,miny) );
     }
     //верную часть меток оси y
     for (double i =0 ; i <= Koly;i++) {
         double n = i*Vody;
        String name=""+n;
     g.drawLine(CX(-maxx/50,maxx,minx), CY(-i*Vody,maxy,miny),CX(maxx/50,maxx,minx), CY(-i*Vody,maxy,miny));
     g.drawString(name,CX(maxx/40,maxx,minx) ,CY(-i*Vody,maxy,miny) );
     }
     //нижную
     for (double i =0 ; i <= -Kolym;i++) {
         double n = -i*Vody;
        String name=""+n;
     g.drawLine(CX(-maxx/50,maxx,minx), CY(i*Vody,maxy,miny),CX(maxx/50,maxx,minx), CY(i*Vody,maxy,miny));
     g.drawString(name,CX(maxx/40,maxx,minx) ,CY(i*Vody,maxy,miny) );
     }
    //x
    g.drawLine(CX(minx,maxx,minx),CY(0,maxy,miny),CX(maxx,maxx,minx),CY(0,maxy,miny));
    g.drawString("X",Wth-Wth/20,Hig/2+Hig/25 );
    //y
    g.drawLine(CX(0,maxx,minx),CY(-miny,maxy,miny),CX(0,maxx,minx),CY(-maxy,maxy,miny));
    g.drawString("Y",Wth/2-Wth/25,Hig/20 );
  
  g.setColor(Color.green);
  //выбираем какую именно функцию рисуем
     if (cb.getSelectedIndex()==0) {
     funcslojn(g);    
     }else{funclegGraphics(g);}
  }
 //функция первая
   void  funcslojn(Graphics g){
       
    int Px=CX(minx,maxx,minx);
    int Py =CY(0,maxy,miny);
     for (double delta=(minx); delta<=(maxx); delta+=(4*Pi/200)) {
     CX=CX(delta,maxx,minx);
     double d;
      d =Math.cos(delta)*Math.exp(Math.sin(delta));
   CY=CY(d,maxy,miny);
   CX=CX(delta,maxx,minx);
     g.drawLine(Px, Py, CX, CY);
     Px=CX;
     Py=CY;
     }}
    void  funclegGraphics (Graphics g){
    int    i=0;
    int Px=CX(minx,maxx,minx);
    int Py =CY(0,maxy,miny);
    //вторая
     for (double delta=(minx); delta<=(maxx); delta+=(4*Pi/200)) {
         
     CX=CX(delta,maxx,minx);
     double d;
      d =Math.sin(delta);
   CY=CY(d,maxy,miny);
   CX=CX(delta,maxx,minx);
   
     g.drawLine(Px, Py, CX, CY);
     Px=CX;
     Py=CY;
     }}
 }
 
}
