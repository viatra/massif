function [ output_args ] = return_cell_array( cell_array_dim_row, cell_array_dim_col)
%RETURN_CELL_ARRAY Summary of this function goes here
%   Detailed explanation goes here

output_args = cell(cell_array_dim_row,cell_array_dim_col);

k=1;
for I=1:cell_array_dim_row
    for J = 1:cell_array_dim_col
        output_args{I,J} = k;
        k = k+1;
    end
end