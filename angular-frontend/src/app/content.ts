import { Company } from './company';
import { Sort } from './sort';
import { Pageable } from './pageable';
export class Content{
  content: Company;
  empty: boolean;
  first: boolean;
  last: boolean;
  number: number;
  numberOfElements: number;
  pageable: Pageable;
  size: number;
  sort: Sort;
  totalElements: number;
  totalPages: number;
}
