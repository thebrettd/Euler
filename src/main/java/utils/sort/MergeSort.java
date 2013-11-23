package utils.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort{

    private MergeSort() {}

    public static List<Integer> mergeSort(List<Integer> input){

        if(input.size() == 1){
            return input;
        }

        List<Integer> firstHalf = input.subList(0,input.size() / 2);
        List<Integer> secondHalf = input.subList(input.size() / 2, input.size());

        return merge( mergeSort(firstHalf), mergeSort(secondHalf));

    }

    public static List<Integer> merge(List<Integer> listOne, List<Integer> listTwo){
        List<Integer> sortedList = new ArrayList<Integer>();

        if(listOne.size() == 0 || listTwo.size() == 0){
            throw new IllegalStateException("input list cannot be empty");
        }

        int listOneIndex = 0;
        int listTwoIndex = 0;
        while(listOneIndex < listOne.size() && listTwoIndex < listTwo.size()){
            if(listOne.get(listOneIndex).compareTo(listTwo.get(listTwoIndex)) < 0){
                sortedList.add(listOne.get(listOneIndex));
                ++listOneIndex;
            }else{
                sortedList.add(listTwo.get(listTwoIndex));
                ++listTwoIndex;
            }
        }
        while(listOneIndex < listOne.size()){
            sortedList.add(listOne.get(listOneIndex));
            ++listOneIndex;
        }
        while(listTwoIndex < listTwo.size()){
            sortedList.add(listTwo.get(listTwoIndex));
            ++listTwoIndex;
        }


        return sortedList;
    }

    public static boolean isSorted(List<Integer> sortedList) {

        for(int i=0;i<sortedList.size()-1;i++){
            if(sortedList.get(i+1) < sortedList.get(i)){
                return false;
            }
        }
        return true;
    }


}
