import javax.swing.*;
import java.awt.*;
import java.util.List;

public class QuickSort implements SortAlgorithm {
    public long sort(List<String> strings) {
        Frame[] frame = JFrame.getFrames();
        JProgressBar pb = new JProgressBar();
        pb.setMaximum((int) (strings.size() *Math.log10(strings.size())));
        pb.setBounds(444,500,135,45);
        JFrame f=new JFrame();
        f.setBounds(444,620,30,50);
        JLabel lbl=new JLabel();
        lbl.setBounds(0,100,50,50);
        f.setVisible(true);
        f.add(lbl);
        frame[0].add(pb);
        int count=0;
        long start=System.currentTimeMillis();
        int low = 0;
        int high = strings.size() - 1;
        quicksort(strings, low, high,count,pb,start,lbl);
        long end=System.currentTimeMillis();
        //System.out.println(strings);
        return (end-start);
    }
    private void quicksort(List<String> strings, int low, int high, int count, JProgressBar pb, long start, JLabel lbl) {

        int i,j,pivot,percent=0;
        long difference=1000;
        String temp;
        if (low<high) {
            pivot = low;
            i=low;
            j=high;
            while (i<j){
                while (strings.get(i).compareTo(strings.get(pivot))<=0 &&i<high){
                    i++;
                    while (strings.get(j).compareTo(strings.get(pivot))>0 )
                        j--;
                    if (pb.getValue()<pb.getMaximum()){
                        count++;
                        pb.setValue(count);
                        //System.out.println(count);
                        if ((count / (pb.getMaximum() / 100)) > percent) {
                            percent = (count / (pb.getMaximum() / 100));
                            String s = percent + "%";
                            lbl.setText(s);
                        }
                        if (System.currentTimeMillis()-start >=difference && System.currentTimeMillis()-start <=difference+150){
                            lbl.setText(percent+"%");
                            difference+=25;
                        }
                    }
                   if (i<j){
                        temp=strings.get(i);
                        strings.set(i,strings.get(j));
                        strings.set(j,temp);
                    }
                }
                temp=strings.get(pivot);
                strings.set(pivot,strings.get(j));
                strings.set(j,temp);
                quicksort(strings,low,j-1,count, pb, start, lbl);
                quicksort(strings,j+1,high,count, pb, start, lbl);
            }
        }
    }
}
