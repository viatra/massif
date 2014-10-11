function output_args = return_prefixed_cell_array( number )
output_args = {};
switch number
    
    case 0
        output_args = {};
        
    case 1
        output_args = {{}};
        
    case 2
        output_args = {{},{}};
    
    case 3
        output_args = {{'a'},{'b'}};    

    case 4
        output_args = {{'a'},{'b'},'c'};
    
    case 5
        output_args = {{'a'},{'b'},'c'}';
        
    case 6
        output_args = {{{'a'},{'b'},'c'} {{'a'},{'b'},'c'}};

    case 7
        output_args = {{{'a'},{'b'},'c'} {{'a'},{'b'},'c'}}';
        
    case 8
        output_args = {'a'};

    case 9
        output_args = {'a' 'b'};
        
    case 10
        output_args = {'a' 'b'}';
    case 11
        output_args = {{{}}};
    case 12 
       output_args = ['abc';'gcb';'hyg'];
    case 13
       output_args = {['abc';'gcb';'hyg']};
end