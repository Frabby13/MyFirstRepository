import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HeapSort implements SortAlgorithm{

    @Override
    public long sort(List<String> strings) {
        Frame[] frame = JFrame.getFrames();
        JProgressBar pb = new JProgressBar();
        pb.setMaximum((int) (strings.size() *1.5));
        pb.setBounds(777,500,135,45);
        frame[0].add(pb);
        int count=0;
        long start=System.currentTimeMillis();
        heapsort(strings, count, pb,start);
        long end=System.currentTimeMillis();
        //System.out.println(strings);
        return (end-start);
    }

    private void heapsort(List<String> strings, int count, JProgressBar pb, long start) {
        long difference=10;
        double percent=0;
        JFrame f=new JFrame();
        f.setBounds(777,620,30,50);
        JLabel lbl=new JLabel();
        lbl.setBounds(0,100,50,50);
        f.add(lbl);
        for(int i=(strings.size()-1)/2; i>=0; i--) {
            heapify(strings, i, strings.size() - 1,count);
            count++;
            pb.setValue(count);
            if (System.currentTimeMillis()-start >=difference && System.currentTimeMillis()-start <=difference+100){
                f.setVisible(true);
                difference+=15;
                lbl.setText(percent+"%");
            }if ((double)(count / (pb.getMaximum() / 100)) > percent) {
                percent = (float)(count / (pb.getMaximum() / 100));
            }
        }
        int size=strings.size()-1;
        for (int i=size;i>0;i--) {
            exchange(strings, i, size);
            size--;
            heapify(strings,0,size,count);
            count++;
            pb.setValue(count);
            if ((double)(count / (pb.getMaximum() / 100)) > percent) {
                percent = (float)(count / (pb.getMaximum() / 100));f.setVisible(true);
                difference+=15;
                lbl.setText(percent+"%");
            }
        }
        if (pb.getValue()==pb.getMaximum())
            lbl.setText("100%");
    }

    private void heapify(List<String> strings, int i, int size,int count) {
        int left=2*i+1;
        int right=2*i+2;
        int max;
        if (left<=size&&strings.get(left).compareTo(strings.get(i))<0)
            max=left;
        else
            max=i;
        if (right<=size&&strings.get(right).compareTo(strings.get(max))<0)
            max=right;
        if (max!=i) {
            exchange(strings, i, max);
            count++;
            heapify(strings,max,size,count);
        }
    }

    private void exchange(List<String> strings, int i, int j) {
        String temp=strings.get(i);
        strings.set(i,strings.get(j));
        strings.set(j,temp);
    }
}
