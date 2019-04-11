import { Component, OnInit } from '@angular/core';
import {CategoryService} from "../services/category.service";
import {forEach} from "@angular/router/src/utils/collection";

class Category {
  id: number;
  name: string;
  inheritAttribute: boolean;
  childCategories: [Category];
}

class TreeNode {
  title: string;
  key: string;
  expaned: boolean;
  children: [TreeNode];
  isLeaf: boolean
}

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  nodes = [
    {
      title: 'parent 1',
      key: '100',
      expanded: true,
      children: [
        {
          title: 'parent 1-0',
          key: '1001',
          expanded: true,
          children: [
            { title: 'leaf', key: '10010', isLeaf: true },
            { title: 'leaf', key: '10011', isLeaf: true },
            { title: 'leaf', key: '10012', isLeaf: true }
          ]
        },
        {
          title: 'parent 1-1',
          key: '1002',
          children: [{ title: 'leaf', key: '10020', isLeaf: true }]
        },
        {
          title: 'parent 1-2',
          key: '1003',
          children: [{ title: 'leaf', key: '10030', isLeaf: true }, { title: 'leaf', key: '10031', isLeaf: true }]
        }
      ]
    }
  ];

  constructor(private categoryService: CategoryService) { }

  ngOnInit() {

    this.categoryService.getCategory(1).subscribe((data: Category)=> {

      var newData = [];

      newData['title'] = "hello";

      console.log(data.childCategories);

    })

  }

  createTreeNodes(data: Category) : TreeNode {

  }

}
