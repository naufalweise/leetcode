use std::collections::HashMap;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
       let num_to_indices: HashMap<i32, Vec<i32>> = nums.iter().enumerate().fold(HashMap::new(), |mut acc, (i, val)| {
            acc.entry(*val).or_default().push(i as i32);
            acc
       });

           
       let result= num_to_indices.iter().find_map(|(val, val_indices)| {
            let diff = target - val;
            if diff == *val {
                if val_indices.len() >= 2 {
                    return Some(vec![val_indices[0], val_indices[1]])
                } else {
                    return None;
                }
            }
            num_to_indices.get(&diff).map(|diff_indices| vec![diff_indices[0], val_indices[1]])
       });
       result.unwrap_or_default()
    }
}
