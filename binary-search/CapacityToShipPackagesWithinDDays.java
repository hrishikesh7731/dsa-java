class Solution {
    public int shipWithinDays(int[] weights, int dayss) {
        int left=0,right=0;

        for(int w : weights){
            left=Math.max(left,w);
            right+=w;
        }
        int ans=right;

        while(left<=right){

            int days=1,load=0;
            int mid = left+(right-left)/2;

            for(int w:weights){
                if(load+w>mid){
                    days++;
                    load=w;
                }else{
                    load+=w;
                }
            }
            if(days<=dayss){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
}
