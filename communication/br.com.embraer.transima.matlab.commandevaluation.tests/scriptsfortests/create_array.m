function test_array = create_array(option1,option2)

if nargin ~= 2
    return
end

%WARNING: DATA TYPES LIKE STRUCT AND FUNCTION HANDLE WILL NOT BE TESTED!

switch option1
    case 'char'
        if strcmp(option2,'row')
            test_array(1,1)   = 'a';
            test_array(1,2)   = 'b';
            test_array(1,3)   = 'c';
        end
        if strcmp(option2,'column')
            test_array(1,1)   = 'a';
            test_array(2,1)   = 'b';
            test_array(3,1)   = 'c';
        end
        if strcmp(option2,'three')
            test_array(1,1,1)   = 'a';
            test_array(1,2,1)   = 'b';
            test_array(3,1,1)   = 'c';
            test_array(3,1,2)   = 'd';
        end
        if strcmp(option2,'matrix')
            test_array(:,:,2) = ['a1','b1';'c1','d1'];
            test_array(:,:,1) = ['a2','b2';'c2','d2'];
        end
    case 'string'
        if strcmp(option2,'row')
            test_array   = ['aaa' 'bbb' 'ccc'];
        end
        if strcmp(option2,'column')
            test_array   = ['aaa';'bbb';'ccc'];
        end        
        
    case 'cell'
        if strcmp(option2,'row')
            test_array = cell(1,3);
            test_array{1}   = 'aaa';
            test_array{2}   = pi;
            test_array{3}   = true;
        end
        if strcmp(option2,'column')
            test_array = cell(3,1);
            test_array{1}   = 'aaa';
            test_array{2}   = pi;
            test_array{3}   = true;
        end

    case 'double'
        if strcmp(option2,'row')
            test_array(1,1)   = double(pi);
            test_array(1,2)   = double(2*pi);
            test_array(1,3)   = double(3*pi);
        end
        if strcmp(option2,'column')
            test_array(1,1)   = double(pi);
            test_array(2,1)   = double(2*pi);
            test_array(3,1)   = double(3*pi);
        end
        if strcmp(option2,'three')
            test_array(1,1,1)   = 1.0;
            test_array(1,2,1)   = 2.0;
            test_array(3,1,1)   = 3.0;
            test_array(3,1,2)   = 4.0;
        end
        if strcmp(option2,'matrix')
            test_array(:,:,2) = [1,2; 3,4];
            test_array(:,:,1) = [5,6; 7,8];
        end

    case 'single'
        if strcmp(option2,'row')            
            test_array(1,1)   = single(pi);
            test_array(1,2)   = single(2*pi);
            test_array(1,3)   = single(3*pi);
        end        
        if strcmp(option2,'column')
            test_array(1,1)   = single(pi);
            test_array(2,1)   = single(2*pi);
            test_array(3,1)   = single(3*pi);
        end        
        
    case 'logical'
        if strcmp(option2,'row')
            test_array(1,1)   = true;
            test_array(1,2)   = false;
            test_array(1,3)   = true;
        end        
        if strcmp(option2,'column')
            test_array(1,1)   = true;
            test_array(2,1)   = false;
            test_array(3,1)   = true;
        end  
        
    case 'int8'
        if strcmp(option2,'row')
            test_array(1,1)   = int8(10);
            test_array(1,2)   = int8(11);
            test_array(1,3)   = int8(12);
        end        
        if strcmp(option2,'column')
            test_array(1,1)   = int8(10);
            test_array(2,1)   = int8(11);
            test_array(3,1)   = int8(12);
        end

    case 'int16'
        if strcmp(option2,'row')
            test_array(1,1)   = int16(10);
            test_array(1,2)   = int16(11);
            test_array(1,3)   = int16(12);
        end        
        if strcmp(option2,'column')
            test_array(1,1)   = int16(10);
            test_array(2,1)   = int16(11);
            test_array(3,1)   = int16(12);
        end      
        
    case 'int32'
        if strcmp(option2,'row')
            test_array(1,1)   = int32(10);
            test_array(1,2)   = int32(11);
            test_array(1,3)   = int32(12);
        end        
        if strcmp(option2,'column')
            test_array(1,1)   = int32(10);
            test_array(2,1)   = int32(11);
            test_array(3,1)   = int32(12);
        end      

    case 'int64'
        if strcmp(option2,'row')
            test_array(1,1)   = int64(10);
            test_array(1,2)   = int64(11);
            test_array(1,3)   = int64(12);
        end        
        if strcmp(option2,'column')
            test_array(1,1)   = int64(10);
            test_array(2,1)   = int64(11);
            test_array(3,1)   = int64(12);
        end      

    case 'uint8'
        if strcmp(option2,'row')
            test_array(1,1)   = uint8(10);
            test_array(1,2)   = uint8(11);
            test_array(1,3)   = uint8(12);
        end        
        if strcmp(option2,'column')
            test_array(1,1)   = uint8(10);
            test_array(2,1)   = uint8(11);
            test_array(3,1)   = uint8(12);
        end

    case 'uint16'
        if strcmp(option2,'row')
            test_array(1,1)   = uint16(10);
            test_array(1,2)   = uint16(11);
            test_array(1,3)   = uint16(12);
        end        
        if strcmp(option2,'column')
            test_array(1,1)   = uint16(10);
            test_array(2,1)   = uint16(11);
            test_array(3,1)   = uint16(12);
        end      
        
    case 'uint32'
        if strcmp(option2,'row')
            test_array(1,1)   = uint32(10);
            test_array(1,2)   = uint32(11);
            test_array(1,3)   = uint32(12);
        end        
        if strcmp(option2,'column')
            test_array(1,1)   = uint32(10);
            test_array(2,1)   = uint32(11);
            test_array(3,1)   = uint32(12);
        end      

    case 'uint64'
        if strcmp(option2,'row')
            test_array(1,1)   = uint64(10);
            test_array(1,2)   = uint64(11);
            test_array(1,3)   = uint64(12);
        end        
        if strcmp(option2,'column')
            test_array(1,1)   = uint64(10);
            test_array(2,1)   = uint64(11);
            test_array(3,1)   = uint64(12);
        end              
        
        
    otherwise
        test_array = [];
        disp('wrong arguments! Usage: create_array(''cell'',''row'') or create_array(''int8'',''column'') or create_array(''logical'',''row'') or create_array(''double'',''column'')')
end

end