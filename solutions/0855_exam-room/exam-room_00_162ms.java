class ExamRoom {
    private Set<Integer> seats;
    private int num;
    public ExamRoom(int N) {
        this.seats = new TreeSet<>();
        this.num = N;
    }

    public int seat() {
        if(seats.isEmpty()){
            seats.add(0);
            return 0;
        }
        Iterator<Integer> iterator = seats.iterator();
        int maxDist = iterator.next(), maxDistIndex = 0, last, cur = maxDist, tmpDist;
        while(iterator.hasNext()){
            last = cur;
            cur = iterator.next();

            tmpDist = (cur - last) / 2;
            if(tmpDist > maxDist){
                maxDist = tmpDist;
                maxDistIndex = last + tmpDist;
            }
        }

        if(cur != num - 1){
            tmpDist = num - cur - 1;
            if(tmpDist > maxDist){
                maxDistIndex = num - 1;
            }
        }
        seats.add(maxDistIndex);

        return maxDistIndex;
    }

    public void leave(int p) {
        seats.remove(p);
    }
//     private int[] seats;
//     private int numSeat;

//     public ExamRoom(int N) {
//         this.numSeat = N;
//         this.seats = new int[N];
//         setDist(1 - numSeat, numSeat + numSeat - 2);
//     }

//     public int seat() {
//         int maxDistIndex = 0, maxDist = -1, seat = 0;
//         int i = 0;

//         // 寻找合适的座位
//         while (i < numSeat) {
//             if (seats[i] == 0) {
//                 ++i;
//             } else {
//                 if(seats[i] + i > numSeat - 1)
//                     maxDistIndex = numSeat - i > maxDist + 1 ? i : maxDistIndex;
//                 else
//                     maxDistIndex = seats[i] > maxDist + 1 ? i : maxDistIndex;
//                 maxDist = seats[maxDistIndex];
//                 i += seats[i];
//             }
//         }

//         if (maxDistIndex == 0)
//             seat = 0;
//         else {
//             int tmp = maxDistIndex + maxDist / 2 - (maxDist % 2 == 0 ? 1 : 0);
//             if (tmp < numSeat)
//                 seat = tmp;
//             else
//                 seat = numSeat - 1;
//         }
//         seats[seat] = 0;

//         // 根据座位重排数组
//         if (maxDistIndex != 0) {
//             setDist(maxDistIndex - seats[maxDistIndex - 1], seat);
//         }
//         if (maxDistIndex != numSeat - 1)
//             setDist(seat + 1, maxDistIndex + 1 + seats[maxDistIndex + 1]);
//         return seat;
//     }

//     // 假设right处位置被占用，从left处开始计算距离
//     private void setDist(int left, int right) {
//         int N = right - left;
//         for (int i = left; i < right; ++i)
//             if (i > -1 && i < numSeat)
//                 seats[i] = N - i + left;
//     }

//     public void leave(int p) {
//         if (seats[p] != 0)
//             return;

//         int left, right;
//         if (p == 0) {
//             left = 0;
//         } else {
//             left = p - 1;
//             while (left > -1 && seats[left] != 0) --left;
//             ++left;
//         }

//         right = p + 1;
//         while (right < numSeat && seats[right] != 0) ++right;

//         if (left < 1 && seats[0] != 0)
//             left = 1 - numSeat;
//         if (right > numSeat - 2 && p == numSeat - 1)
//             right = numSeat + numSeat - 2;

//         setDist(left, right);
//     }
}
/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */