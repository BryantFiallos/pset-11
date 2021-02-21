import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ProblemSet11 {

    public static void main(String[] args) {

        /*
        ProblemSet11 woo = new ProblemSet11();

        //ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2, 4));



        // System.out.print(woo.fizzBuzz(1, 6));
        //System.out.print(woo.maxSpan(list));
        //System.out.print(woo.fix34(list));
        //System.out.print(woo.fix45(list));
        //System.out.print(woo.canBalance(list));
        //System.out.print(woo.linearIn(list, list2));
        //System.out.print(woo.squareUp(3));
        //System.out.print(woo.seriesUp(2));
        //System.out.print(woo.maxMirror(list));
        System.out.print(woo.countClumps(list));


        */

    }

    public ArrayList<String> fizzBuzz(int start, int end) {

        if (start >= end) {

            return null;
        }

        ArrayList<String> result = new ArrayList<>();
        int resultIndex = 0;

        for (int i = start; i < end; i++) {

            if (i % 3 == 0 && i % 5 == 0) {

                result.add("FizzBuzz");
                resultIndex++;

            }

            else if (i % 3 == 0) {

                result.add("Fizz");
                resultIndex++;

            }

            else if (i % 5 == 0) {

                result.add("Buzz");
                resultIndex++;

            }

            else {

                String stringValue = String.valueOf(i);
                result.add(stringValue);
                resultIndex++;

            }
        }


        return result;

    }

    public int maxSpan(ArrayList<Integer> numbers) {

        if (numbers == null) {

            return -1;

        }

        int span = 0;
        int max = 0;

        for (int i = 0; i < numbers.size(); i++) {

            int x = numbers.size() - 1;

            while (numbers.get(i) != numbers.get(x)) {

                x--;

            }

            span = x - i + 1;
            max = Math.max(span,max);

        }

        return max;

    }

    public ArrayList<Integer> fix34(ArrayList<Integer> numbers) {

        int threeCounter = 0;
        int fourCounter = 0;
        int firstThree = -1;
        int firstFour = -1;
        boolean valid = true;
        int temp;


        for (int i = 0; i < numbers.size(); i++) {

            if (numbers.get(i) == 3) {

                if (firstThree < 0) {
                    firstThree = i;
                }

                if (i < (numbers.size() - 1)){
                    if (numbers.get(i+1) == 4) {

                        valid = false;

                    }
                }

                threeCounter++;

            }

            if (numbers.get(i) == 4) {

                if (firstFour < 0) {
                    firstFour = i;
                }

                fourCounter++;

            }

        }

        if (numbers == null || threeCounter != fourCounter || firstThree > firstFour || valid == false) {

            return null;

        }

        for (int j = 0; j < numbers.size(); j++) {

            if (numbers.get(j) == 3) {

                for (int x = 0; x < numbers.size(); x++) {

                    if (numbers.get(x) == 4 && numbers.get(x-1) != 3) {

                        numbers.set(x, numbers.get(j+1));
                        numbers.set(j+1, 4);


                    }

                }

            }

        }

        return numbers;

    }

    public ArrayList<Integer> fix45(ArrayList<Integer> numbers) {

        int fiveCounter = 0;
        int fourCounter = 0;
        boolean valid = true;
        int temp;


        for (int i = 0; i < numbers.size(); i++) {

            if (numbers.get(i) == 4) {

                if (i < (numbers.size() - 1)){
                    if (numbers.get(i+1) == 4) {

                        valid = false;

                    }
                }

                fourCounter++;

            }

            if (numbers.get(i) == 5) {

                fiveCounter++;

            }

        }

        if (numbers == null || fiveCounter != fourCounter || valid == false) {

            return null;

        }

        for (int j = 0; j < numbers.size()-1; j++) {

            if (numbers.get(j) == 4) {

                for (int x = 0; x < numbers.size(); x++) {

                    if (x > 0) {
                        if (numbers.get(x) == 5 && numbers.get(x-1) != 4) {

                            numbers.set(x, numbers.get(j+1));
                            numbers.set(j+1, 5);


                        }
                    }

                    else {

                        if (numbers.get(x) == 5) {

                            numbers.set(x, numbers.get(j+1));
                            numbers.set(j+1, 5);


                        }

                    }

                }

            }

        }

        return numbers;

    }

    public boolean canBalance(ArrayList<Integer> numbers) {

        if (numbers == null || numbers.size() == 0) {

            return false;

        }

        int leftSum = 0;
        int rightSum = 0;
        boolean result = false;

        for (int i = 0; i < numbers.size(); i++) {

            leftSum += numbers.get(i);
            rightSum = 0;

            for (int j = i+1; j < numbers.size(); j++) {

                rightSum += numbers.get(j);

            }

            if (leftSum == rightSum) {

                result = true;
                break;
            }

        }

        return result;

    }

    public boolean linearIn(ArrayList<Integer> outer, ArrayList<Integer> inner) {

        boolean outerIncreasing = true;
        boolean innerIncreasing = true;
        boolean found = false;

        for (int i = 0; i < outer.size()-1; i++) {

            if(outer.get(i) > outer.get(i+1)) {

                outerIncreasing = false;
                break;

            }

        }

        for (int i = 0; i < inner.size()-1; i++) {

            if(inner.get(i) > inner.get(i+1)) {

                innerIncreasing = false;
                break;

            }

        }

        if (outer == null || inner == null || outer.size() == 0 || inner.size() == 0 || outerIncreasing == false || innerIncreasing == false) {

            return false;

        }

        for (int i = 0; i < outer.size(); i++) {

            int currentOuter = i;
            int match = 0;

            for (int j = 0; j < inner.size(); j++) {

                if (outer.size() - i >= inner.size()) {


                    if (outer.get(currentOuter) == inner.get(j)) {

                        match++;

                    }

                    if (match == inner.size()) {

                        found = true;
                        break;

                    }

                    currentOuter++;

                }

            }
        }

        return  found;

    }

    public ArrayList<Integer> squareUp(int n) {

        if (n < 0) {

            return null;

        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n*n; i++) {

            result.add(0);

        }

        for (int i = 1; i <= n; i++) {

            int x = i*n-1;
            int currentIndex = x;

            for (int j = 1; j <= i; j++) {


                result.set(currentIndex, j);
                currentIndex--;

            }

        }

        return result;

    }

    public ArrayList<Integer> seriesUp(int n) {

        if (n < 0) {

            return null;

        }

        ArrayList<Integer> result = new ArrayList<>();
        int nextValue = 0;
        int currentLimit = 1;

        for (int f = 0; f < (n*(n+1)) / 2; f++) {

            result.add(0);

        }

        for (int i = 0; i < result.size(); i++) {

            nextValue++;
            result.set(i, nextValue);

            if (nextValue == currentLimit) {

                currentLimit++;
                nextValue = 0;

            }

        }

        return result;

    }

    public int maxMirror(ArrayList<Integer> numbers) {

        if (numbers == null) {

            return -1;

        }

        ArrayList<Integer> reversed = new ArrayList<>();
        int reversedIndex = 0;
        int max = 0;
        int matches = 0;

        for (int f = 0; f < numbers.size(); f++) {

            reversed.add(0);

        }

        for (int i = numbers.size()-1; i >= 0; i--) {

            reversed.set(reversedIndex, numbers.get(i));
            reversedIndex++;

        }

        for (int i = 0; i < numbers.size(); i++) {

            int currentIndex = i;

            inner:
            for (int j = 0; j < reversed.size(); j++) {

                if (numbers.get(currentIndex) == reversed.get(j)) {

                    matches++;
                    max = Math.max(matches, max);

                    if (currentIndex < numbers.size()-1) {
                        currentIndex++;
                    }


                }
                else {

                    matches = 0;

                }

                if (currentIndex == numbers.size()-1) {

                    break inner;

                }



            }

        }

        return max;

    }

    public int countClumps(ArrayList<Integer> numbers) {

        if (numbers == null) {

            return -1;

        }

        int clumps= 0;
        boolean isClump = false;

        for (int i = 0; i < numbers.size()-1; i++) {

            if (!isClump) {
                if (numbers.get(i) == numbers.get(i+1)) {

                    clumps++;
                    isClump = true;

                }
            }
            else if (isClump) {

                if (numbers.get(i) != numbers.get(i+1)) {

                    isClump = false;

                }
            }

        }

        return clumps;

    }
}
