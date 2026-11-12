package web.mvc.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.mvc.dao.ProductDAO;
import web.mvc.dto.ProductDTO;
import web.mvc.exception.ErrorCode;
import web.mvc.exception.MyErrorException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{
	
	private final ProductDAO productDao;
	
	private final static int MIN_PRICE=1000;
	private final static int MAX_PRICE=10000;
	
	@PostConstruct
	public void init() {
	    log.info("productDao ={}" , productDao);
	}

	@Override
	public List<ProductDTO> select() {
		
		return productDao.select();
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		//가격 1000 ~ 10000사이 체크
		
		if(productDTO.getPrice() < MIN_PRICE || productDTO.getPrice() > MAX_PRICE) {
			throw new MyErrorException(ErrorCode.INVALID_PRICE);
		}
		
		int result = productDao.insert(productDTO);
				
		return result;
	}

	@Override
	public int delete(String code) throws MyErrorException {
		int result = productDao.delete(code);
		return result;
	}

	@Override
	public ProductDTO selectByCode(String code) throws MyErrorException {
		ProductDTO product = productDao.selectByCode(code);
		if(product==null)
			throw new MyErrorException(ErrorCode.INVALID_PRODUCT_CODE);
		
		return product;
	}

	@Override
	public int updateByCode(ProductDTO productDTO) throws MyErrorException {
		
		return productDao.updateByCode(productDTO);
	}

}
