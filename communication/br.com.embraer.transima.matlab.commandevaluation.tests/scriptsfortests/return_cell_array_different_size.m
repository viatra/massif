function [output,elapsed_time] = return_cell_array_different_size( option )
%RETURN_CELL_ARRAY_DIFFERENT_SIZE Summary of this function goes here
%   Detailed explanation goes here

switch option
    
    case 0
        tic
        output = {};
        elapsed_time = toc;
    case 1
        tic
        X = 10^1;
        output = cell(X,1);
        for I = 1:X
            output{I}= I;
        end
        elapsed_time = toc;
        
    case 2
        tic
        X = 10^2;
        output = cell(X,1);
        for I = 1:X
            output{I}= I;
        end
        elapsed_time = toc;
    case 3
        tic
        X = 10^3;
        output = cell(X,1);
        for I = 1:X
            output{I}= I;
        end
       elapsed_time = toc;        
    case 4
        tic
        X = 10^4;
        output = cell(X,1);
        for I = 1:X
            output{I}= I;
        end
       elapsed_time = toc;               
    case 5
        tic
        X = 10^5;
        output = cell(X,1);
        for I = 1:X
            output{I}= I;
        end
       elapsed_time = toc;
    case 6
        tic
        X = 10^6;
        output = cell(X,1);
        for I = 1:X
            output{I}= I;
        end
        elapsed_time = toc;

    case 100
        tic
        output = {};
        elapsed_time = toc;
    case 101
        tic
        X = 10^1;
        aux = cell(X,1);
        for I = 1:X
            aux{I}= I;
        end
        output = {};
        elapsed_time = toc;
        
    case 102
        tic
        X = 10^2;
        aux = cell(X,1);
        for I = 1:X
            aux{I}= I;
        end
        output = {};
        elapsed_time = toc;
    case 103
        tic
        X = 10^3;
        aux = cell(X,1);
        for I = 1:X
            aux{I}= I;
        end
        output = {};
       elapsed_time = toc;        
    case 104
        tic
        X = 10^4;
        aux = cell(X,1);
        for I = 1:X
            aux{I}= I;
        end
        output = {};        
        elapsed_time = toc;

    case 105
        tic
        X = 10^5;
        aux = cell(X,1);
        for I = 1:X
            aux{I}= I;
        end
        output = {};        
        elapsed_time = toc;
        
    case 106
        tic
        X = 10^6;
        aux = cell(X,1);
        for I = 1:X
            aux{I}= I;
        end
        output = {};        
        elapsed_time = toc;        
        

        
        
        
    case 16
        tic
        X = 10^2;
        aux = cell(X,1);
        for I = 1:X
            aux{I}= I;
        end        
        output = {{aux};{aux};{aux};};
        elapsed_time = toc;        
    case 17
        tic
        X = 10^3;
        aux = cell(X,1);
        for I = 1:X
            aux{I}= I;
        end        
        output = {{aux};{aux};{aux};};        
        elapsed_time = toc;        
    case 18
        tic
        X = 10^2;
        aux = cell(X,1);
        for I = 1:X
            aux{I}= I;
        end        
        output = {{{aux};{aux};{aux};},{{aux};{aux};{aux};},{{aux};{aux};{aux};}};
        elapsed_time = toc;
    case 19  
        tic
        X = 10^2;
        aux = cell(X,1);
        for I = 1:X
            aux{I}= I;
        end        
        output = {{{aux};{aux};{aux};},{{aux};{aux};{aux};},{{aux};{aux};{aux};}};
        elapsed_time = toc;
        
    case 20
        tic
        X = 10^5;
        aux = cell(X,1);
        for I = 1:X
            aux{I}= I;
        end        
        output = {{{aux};{aux};{aux};},{{aux};{aux};{aux};},{{aux};{aux};{aux};}};
        elapsed_time = toc;        
end

