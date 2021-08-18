import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BubbleSort implements SortAlgorithm{
    public long sort(List<String> list) {
        Frame[] frame = JFrame.getFrames();
        JFrame f=new JFrame();
        f.setBounds(111,620,30,50);
        JLabel lbl=new JLabel();
        lbl.setBounds(0,100,15,50);
        f.add(lbl);
        JProgressBar pb = new JProgressBar();
        pb.setBounds(111,500,135,45);
        pb.setMaximum(list.size()-1);
        frame[0].add(pb);
        long difference=1000;
        long start = System.currentTimeMillis();
        int count=0;
        int percent= 0;
        for (int i = 0; i < list.size(); i++){
            for (int j = 0; j < list.size() - 1; j++){
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    String temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }if (System.currentTimeMillis()-start >=difference && System.currentTimeMillis()-start <=difference+3000){
                f.setVisible(true);
                difference+=1000;
                lbl.setText(percent+"%");
            }
            count++;
            pb.setValue(count);
            if ((count / (pb.getMaximum() / 100)) > percent) {
                percent = (count / (pb.getMaximum() / 100));
            }
        }
        lbl.setText("100%");
        //System.out.println(list);
        long end = System.currentTimeMillis();
        return  (end-start);
    }
}
