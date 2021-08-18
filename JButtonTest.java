import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class JButtonTest extends Thread{
    public static void main(String[] args) throws Exception {
        JFrame f=new JFrame("Button Example");
        f.setName("Frame");
        QuickSort qs = new QuickSort();
        BubbleSort bs = new BubbleSort();
        HeapSort hs =new HeapSort();
        File file =new File("C:\\Users\\FrancescoAlberto\\IdeaProjects\\ex5\\text.txt");
        BufferedReader br=new BufferedReader(new FileReader(file));
        String str;
        StringBuilder s= new StringBuilder();
        while ((str=br.readLine())!=null)
            s.append(str.toLowerCase()).append(" ");
        List<String> words = Arrays.stream(s.toString().split(" ")).collect(Collectors.toList());
        System.out.println(words.size());
        JButton b=new JButton("Run the sorts");
        b.setBounds(444,100,135,45);
        JTextField[] tf=new JTextField[3];
        for (int i=0;i<tf.length;i++){
            tf[i]=new JTextField();
            tf[i].setName("tf"+(i+1));
            tf[i].setBounds(111+(111*i*3),400,135,45);
            switch (i) {
                case 0 -> tf[i].setText("run Bubblesort");
                case 1 -> tf[i].setText("run Quicksort");
                case 2 -> tf[i].setText("run Heapsort");
            }
            tf[i].setEditable(false);
            f.add(tf[i]);
        }
        f.setSize(1000,1000);
        f.setLayout(null);
        f.setVisible(true);
        b.addActionListener(k -> {
            Thread go=new Thread(()->{
                tf[0].setText("Bubblesort: "+bs.sort(words)+"ms");
                tf[1].setText("Quicksort: "+qs.sort(words)+"ms");
                tf[2].setText("Heapsort:"+hs.sort(words)+"ms");
            });
            go.start();
        });
        f.add(b);
        JButton[] buttons = new JButton[3];
        for (int i=0;i< buttons.length;i++){
            buttons[i]=new JButton(tf[i].getText());
            buttons[i].setBounds(111+(111*i*3),450,135,45);
            f.add(buttons[i]);
            int finalI = i;
            buttons[i].addActionListener(e -> {
                switch (finalI){
                    case 0 -> tf[finalI].setText("Bubblesort: "+bs.sort(words)+"ms");
                    case 1 -> tf[finalI].setText("Quicksort: "+qs.sort(words)+"ms");
                    case 2 -> tf[finalI].setText("Heapsort:"+hs.sort(words)+"ms");
                }
            });
        }
    }
}
