function [data_type,print_data] = check_data_type( value )
%CHECK_DATA_TYPE Summary of this function goes here
%   Detailed explanation goes here

data_type  = class(value);
switch data_type
    case 'cell'
        print_data = value;
    case 'java.util.ArrayList'
        print_data = value;
    otherwise
        print_data = sprintf('%s',num2str(value));
end