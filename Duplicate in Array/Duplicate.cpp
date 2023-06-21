#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
    bool containsDuplicate(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        
        for(int i = 0; i < nums.size() - 1; i++) {
           
            if(nums[i] == nums[i+1]) {
                return true;
            }
        }
        
        return false;
    }
};


int main() {

vector<int> num;
 
 int size;

 cin >> size;

 for(int i = 0; i < size; i++) {
    cin >> num[i];
 }

Solution s;
cout << s.containsDuplicate(num);


    return 0;
}
