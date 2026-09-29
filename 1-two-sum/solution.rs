use std::collections::HashMap;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
       let num_to_indices: HashMap<i32, Vec<i32>> = nums.iter().enumerate().fold(HashMap::new(), |mut acc, (i, val)| {
            acc.entry(*val).or_default().push(i as i32);
            acc
       });

           
       let results: Vec<Vec<i32>> = num_to_indices.keys().fold(Vec::new(), |mut acc, val| {
            let diff = target - val;
            let val_indices = num_to_indices.get(val).unwrap();
            if diff == *val {
                if val_indices.len() >= 2 {
                    acc.push(vec![val_indices[0], val_indices[1]]);
                };  
            } else if let Some(diff_indices) = num_to_indices.get(&diff) {
                acc.push(vec![diff_indices[0], val_indices[0]]); 
            }
            acc
       });
       results.into_iter().next().unwrap_or_default()
    }
}
